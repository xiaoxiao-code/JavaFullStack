package lzt.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * MyBatis 的 SqlSession 工具类
 */
public class SqlSessionUtil {

    // 工具类的构造方法一般私有化，防止别人 new 对象
    private SqlSessionUtil() {}

    private static SqlSessionFactory sqlSessionFactory;

    // 全局唯一的一个 ThreadLocal 对象
    private static ThreadLocal<SqlSession> local = new ThreadLocal<>();

    // 静态代码块，类加载时只执行一次，保证全局只有一个 SqlSessionFactory
    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取 SqlSession 对象
     * @return SqlSession
     */
    public static SqlSession openSession() {
        SqlSession sqlSession = local.get();
        if (sqlSession == null) {
            // 如果当前线程没有绑定 SqlSession，就新建一个，并绑定到当前线程
            sqlSession = sqlSessionFactory.openSession();
            local.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * 关闭 SqlSession 对象，并从当前线程中移除
     * 老杜强调：一定要移除！不然在线程池环境下会导致内存泄漏或者拿到别人的连接！
     */
    public static void close(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.close();
            // 务必解绑
            local.remove();
        }
    }
}