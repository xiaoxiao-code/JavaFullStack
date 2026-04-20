package lzt.lztbatis.bank.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * MyBatis 工具类
 */
public class SqlSessionUtil {

    // SqlSessionFactory 对象一个环境只需要一个即可
    private static SqlSessionFactory sqlSessionFactory;

    // 全局的，一个类中定义一个即可。
    // 使用 ThreadLocal 来保证同一个线程使用的是同一个 SqlSession
    private static ThreadLocal<SqlSession> local = new ThreadLocal<>();

    // 静态代码块，在类加载时执行，且只执行一次
    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取当前线程的 SqlSession 对象
     * @return SqlSession
     */
    public static SqlSession openSession() {
        SqlSession sqlSession = local.get();
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession();
            // 将 sqlSession 绑定到当前线程上
            local.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * 关闭 SqlSession，并从当前线程中移除
     * @param sqlSession 要关闭的 SqlSession
     */
    public static void close(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.close();
            // 注意：在 Web 环境下（如 Tomcat），线程池的线程是复用的。
            // 如果这里不移除，可能会导致内存泄漏或下一次请求拿到已经关闭的 SqlSession。
            local.remove();
        }
    }
}