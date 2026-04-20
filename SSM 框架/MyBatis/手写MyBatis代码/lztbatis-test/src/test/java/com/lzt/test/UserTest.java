package com.lzt.test;

import lzt.lztbatis.pojo.User;
import lzt.lztbatis.core.SqlSession;
import lzt.lztbatis.core.SqlSessionFactory;
import lzt.lztbatis.core.SqlSessionFactoryBuilder;
import lzt.lztbatis.utils.Resources;
import org.junit.Test;

import java.io.InputStream;

/**
 * lztBatis 框架的终极测试类
 */
public class UserTest {

    /**
     * 测试向数据库插入一条 User 数据
     */
    @Test
    public void testInsertUser() {
        SqlSession sqlSession = null;
        try {
            // 1. 读取核心配置文件，获取输入流（调用你写的 Resources 工具类）
            InputStream inputStream = Resources.getResourceAsStream("lztbatis-config.xml");

            // 2. 创建 SqlSessionFactoryBuilder 对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

            // 3. 解析 XML，构建出包含大管家 Configuration 的 SqlSessionFactory
            SqlSessionFactory sqlSessionFactory = builder.build(inputStream);

            // 4. 开启一个数据库会话（内部已经搞定了数据库连接和事务管理器）
            sqlSession = sqlSessionFactory.openSession();

            // 5. 准备要插入的数据对象（POJO）
            // 这里我们随机编造一个用户
            User user = new User("user-001", "张三", "zhangsan@powernode.com", "北京市海淀区");

            // 6. 执行 SQL！
            // 拿着 "insertUser" 这个 id 去 UserMapper.xml 里找 SQL，并利用反射把 user 里的属性塞进 SQL 里
            int count = sqlSession.insert("insertUser", user);
            System.out.println("成功插入了几条记录：" + count);

            // 7. 提交事务（极度重要！不提交的话数据进不去数据库）
            sqlSession.commit();

        } catch (Exception e) {
            // 发生异常时回滚事务
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            e.printStackTrace();
        } finally {
            // 8. 释放资源，归还连接
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 测试从数据库查询单条 User 数据并自动封装为对象
     */
    @Test
    public void testSelectUser() {
        SqlSession sqlSession = null;
        try {
            InputStream inputStream = Resources.getResourceAsStream("lztbatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
            sqlSession = sqlSessionFactory.openSession();

            // 执行查询 SQL！
            // 把刚才插入的 "user-001" 传过去。框架会执行 SQL，拿到 ResultSet，
            // 然后利用反射自动 new User()，并把查出来的列值通过 set 方法赋给它。
            Object result = sqlSession.selectOne("selectUserById", "user-001");

            System.out.println("从数据库查到的对象是：");
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}