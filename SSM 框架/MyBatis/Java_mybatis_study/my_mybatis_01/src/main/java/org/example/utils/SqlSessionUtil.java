package org.example.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * MyBatis 核心工具类
 */
public class SqlSessionUtil {

    // 1. 声明一个全局静态的 SqlSessionFactory 对象 (保证单例)
    private static SqlSessionFactory sqlSessionFactory;

    // 2. 声明一个 ThreadLocal 容器，用于绑定当前线程的 SqlSession
    private static ThreadLocal<SqlSession> local = new ThreadLocal<>();

    // 3. 私有化构造方法，防止外部随便 new 这个工具类
    private SqlSessionUtil() {}

    // 4. 静态代码块：类加载时只执行一次，保证工厂全局只创建一次
    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("解析 mybatis-config.xml 失败：", e);
        }
    }

    /**
     * 获取当前线程绑定的 SqlSession 对象
     */
    public static SqlSession openSession() {
        // 先尝试从当前线程的 ThreadLocal 中取
        SqlSession sqlSession = local.get();
        // 如果没取到（说明当前线程是第一次请求）
        if (sqlSession == null) {
            // 从工厂中开启一个新的 SqlSession
            sqlSession = sqlSessionFactory.openSession();
            // 放进 ThreadLocal 绑定当前线程，供后续操作复用
            local.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * 关闭 SqlSession 释放资源，并将其从 ThreadLocal 中移除
     */
    public static void close(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.close();
            // 【极其关键】必须移除，否则在 Tomcat 等使用线程池的 Web 容器中会导致内存泄漏！
            local.remove();
        }
    }
}