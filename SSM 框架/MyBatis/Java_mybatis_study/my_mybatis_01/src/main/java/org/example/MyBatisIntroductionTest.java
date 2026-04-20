package org.example;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatisIntroductionTest {
    public static void main(String[] args) {

        SqlSession sqlSession = null;

        try {
            // 创建SqlSession工厂构建器
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            // 加载MyBatis核心配置文件
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("mybatis-config.xml");
            // 构建SqlSession工厂
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            // 开启数据库会话
            sqlSession = sqlSessionFactory.openSession();
            // 执行插入操作，返回影响行数
            int count = sqlSession.insert("car.insertCar");
            System.out.println("成功插入了几条汽车数据：" + count);
            // 提交事务
            sqlSession.commit();
        } catch (Exception e) {
            // 异常时回滚事务
            if (sqlSession != null) {
                sqlSession.rollback();
                System.out.println("发生异常，事务已回滚！");
            }
            e.printStackTrace();

        } finally {
            // 关闭会话释放资源
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}