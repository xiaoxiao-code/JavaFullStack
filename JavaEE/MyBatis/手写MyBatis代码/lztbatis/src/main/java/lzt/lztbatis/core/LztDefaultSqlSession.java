package lzt.lztbatis.core;
import lzt.lztbatis.mapping.LztMappedStatement;
import lzt.lztbatis.transaction.TransactionManager;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
/**
 * 默认的 SqlSession 实现类
 */
public class LztDefaultSqlSession implements SqlSession {

    /**
     * 依赖核心配置大管家
     * 里面包含了事务管理器和 SQL 映射字典
     */
    private LztConfiguration configuration;

    /**
     * 构造方法：当工厂 openSession() 时，会把 configuration 传给它
     */
    public LztDefaultSqlSession(LztConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void commit() {
        // 从大管家中获取事务管理器，并委托它去提交事务
        TransactionManager transactionManager = this.configuration.getTransactionManager();
        if (transactionManager != null) {
            transactionManager.commit();
        }
    }

    @Override
    public void rollback() {
        // 从大管家中获取事务管理器，并委托它去回滚事务
        TransactionManager transactionManager = this.configuration.getTransactionManager();
        if (transactionManager != null) {
            transactionManager.rollback();
        }
    }

    @Override
    public void close() {
        // 从大管家中获取事务管理器，并委托它去关闭（归还）连接
        TransactionManager transactionManager = this.configuration.getTransactionManager();
        if (transactionManager != null) {
            transactionManager.close();
        }
    }

    @Override
    public int insert(String sqlId, Object pojo) {
        try {
            // 1. 从“大管家”中获取对应的 SQL 映射信息
            LztMappedStatement mappedStatement = configuration.getMappedStatements().get(sqlId);
            if (mappedStatement == null) {
                throw new RuntimeException("未找到对应的 SQL 映射，sqlId: " + sqlId);
            }

            // 这是从 XML 中读取出来的原始 SQL，包含 #{xxx}
            String lztSql = mappedStatement.getSql();

            // 2. 解析 SQL：将 #{xxx} 替换为 ?，并按顺序记录占位符对应的属性名
            List<String> propertyNames = new ArrayList<>();
            String jdbcSql = lztSql;
            int startIndex;
            // 循环查找并替换 #{...}
            while ((startIndex = jdbcSql.indexOf("#{")) >= 0) {
                int endIndex = jdbcSql.indexOf("}", startIndex);
                // 提取出属性名，例如 "carNum"
                String propertyName = jdbcSql.substring(startIndex + 2, endIndex).trim();
                propertyNames.add(propertyName);
                // 将 "#{xxx}" 替换为 JDBC 认识的 "?"
                jdbcSql = jdbcSql.substring(0, startIndex) + "?" + jdbcSql.substring(endIndex + 1);
            }

            // 3. 获取数据库连接并预编译 SQL
            // jdbcSql 现在变成了类似: insert into t_car values(null, ?, ?)
            Connection connection = configuration.getTransactionManager().getConnection();
            PreparedStatement ps = connection.prepareStatement(jdbcSql);

            // 4. 利用反射给 ? 赋值
            for (int i = 0; i < propertyNames.size(); i++) {
                // 取出第 i 个位置需要的属性名
                String propertyName = propertyNames.get(i);

                // 拼接 Getter 方法名 (例如: carNum -> getCarNum)
                String getMethodName = "get" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);

                // 通过反射获取该方法
                Method getMethod = pojo.getClass().getDeclaredMethod(getMethodName);

                // 执行该方法，从 pojo 对象中拿到具体的属性值
                Object propertyValue = getMethod.invoke(pojo);

                // 给 PreparedStatement 中的 ? 赋值 (JDBC 的索引从 1 开始计算)
                ps.setObject(i + 1, propertyValue);
            }

            // 5. 执行更新并返回受影响的行数
            int count = ps.executeUpdate();

            // 注意：这里只关闭 Statement，Connection 要留给 TransactionManager 统一管理和关闭
            ps.close();
            return count;

        } catch (Exception e) {
            throw new RuntimeException("执行 insert 异常", e);
        }
    }

    @Override
    public Object selectOne(String sqlId, Object parameter) {
        try {
            // 1. 从“大管家”中获取对应的 SQL 映射信息
            LztMappedStatement mappedStatement = configuration.getMappedStatements().get(sqlId);
            if (mappedStatement == null) {
                throw new RuntimeException("未找到对应的 SQL 映射，sqlId: " + sqlId);
            }

            // 2. 解析 SQL：针对 selectOne 这种单参数查询，我们可以用正则直接替换 #{xxx} 为 ?
            String lztSql = mappedStatement.getSql();
            // 将类似 "select * from t_car where car_num = #{carNum}" 替换为 "select * from t_car where car_num = ?"
            String jdbcSql = lztSql.replaceAll("#\\{[^}]+\\}", "?");

            // 3. 获取数据库连接并预编译 SQL
            Connection connection = configuration.getTransactionManager().getConnection();
            PreparedStatement ps = connection.prepareStatement(jdbcSql);

            // 4. 给 ? 赋值 (针对你的测试代码传参 "111"，这里只有一个占位符)
            if (parameter != null) {
                ps.setObject(1, parameter);
            }

            // 5. 执行查询，获取结果集
            ResultSet rs = ps.executeQuery();

            // 6. 处理结果集并封装 POJO 对象 (ORM 的灵魂：反射)
            Object resultObj = null;
            if (rs.next()) { // selectOne 默认只处理第一条记录
                // 6.1 获取 XML 中配置的返回值类型 (例如 "com.lzt.pojo.Car")
                String resultType = mappedStatement.getResultType();

                // 6.2 利用反射，根据全限定类名实例化一个空对象
                Class<?> resultClass = Class.forName(resultType);
                resultObj = resultClass.getDeclaredConstructor().newInstance();

                // 6.3 获取 ResultSet 的元数据 (非常重要：能知道查询结果有多少列、列名是什么)
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();

                // 6.4 遍历每一列，把列的值塞进刚才实例化的空对象中
                for (int i = 1; i <= columnCount; i++) {
                    // 获取列名 (例如 "car_num" 或 "brand")
                    String columnName = metaData.getColumnName(i);
                    // 实际的 MyBatis 这里会有一个复杂的转换逻辑 (下划线转驼峰：car_num -> carNum)
                    // 为了框架跑通，我们这里先假设数据库列名和实体类属性名一致，或者忽略大小写匹配
                    String propertyName = columnName;

                    // 拼接 Setter 方法名 (例如 "brand" -> "setBrand")
                    String setMethodName = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);

                    // 获取数据库中该列的值
                    Object columnValue = rs.getObject(i);

                    // 遍历该类的所有方法，找到名字匹配的 Setter 方法进行调用并赋值
                    Method[] methods = resultClass.getDeclaredMethods();
                    for (Method method : methods) {
                        // 忽略大小写匹配方法名，增加容错率
                        if (method.getName().equalsIgnoreCase(setMethodName)) {
                            // 相当于调用 car.setBrand("宝马X7")
                            method.invoke(resultObj, columnValue);
                            break;
                        }
                    }
                }
            }

            // 7. 释放 JDBC 资源
            rs.close();
            ps.close();

            // 8. 返回组装好的完整对象
            return resultObj;

        } catch (Exception e) {
            throw new RuntimeException("执行 selectOne 异常", e);
        }
    }
}