package lzt.lztbatis.transaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * JDBC 事务实现类
 * 依靠底层的数据源来获取连接，并使用原生的 Connection 方法管理事务
 */
public class LztJDBCTransaction implements TransactionManager {

    // 数据源（提供数据库连接的工厂，比如德鲁伊、HikariCP，或者自定义的数据源）
    private DataSource dataSource;
    // 是否自动提交事务
    private boolean autoCommit;
    // 内部维护的 JDBC 数据库连接对象
    private Connection connection;

    /**
     * 构造方法
     * @param dataSource 数据源
     * @param autoCommit 是否自动提交
     */
    public LztJDBCTransaction(DataSource dataSource, boolean autoCommit) {
        this.dataSource = dataSource;
        this.autoCommit = autoCommit;
    }

    @Override
    public Connection getConnection() {
        // 【核心细节：懒加载机制】
        // 只有当程序真正需要执行 SQL 语句，调用 getConnection() 时，才去数据源拿连接。
        // 如果只是创建了 SqlSession 但没执行 SQL，就不占用宝贵的数据库连接资源。
        if (this.connection == null) {
            try {
                this.connection = dataSource.getConnection();
                // 设置底层连接的自动提交属性
                this.connection.setAutoCommit(this.autoCommit);
            } catch (SQLException e) {
                // 实际框架中这里会抛出自定义的异常，这里为了简化暂时打印堆栈
                e.printStackTrace();
            }
        }
        return this.connection;
    }

    @Override
    public void commit() {
        // 只有当连接存在，且不是自动提交模式时，才需要手动提交
        if (this.connection != null && !this.autoCommit) {
            try {
                this.connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void rollback() {
        // 只有当连接存在，且不是自动提交模式时，才需要手动回滚
        if (this.connection != null && !this.autoCommit) {
            try {
                this.connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void close() {
        // 归还或关闭连接
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}