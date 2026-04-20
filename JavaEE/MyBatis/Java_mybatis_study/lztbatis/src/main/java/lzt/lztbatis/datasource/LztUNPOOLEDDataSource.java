package lzt.lztbatis.datasource;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * lztBatis 提供的不使用连接池的数据源实现
 * 每次获取连接都会新建一个真实的物理连接
 */
public class LztUNPOOLEDDataSource implements DataSource {

    // 数据库连接的四大核心参数
    private String driver;
    private String url;
    private String username;
    private String password;

    /**
     * 构造方法：在创建数据源对象时，传入这四个参数并注册驱动
     */
    public LztUNPOOLEDDataSource(String driver, String url, String username, String password) {
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;

        // 注册数据库驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("数据库驱动加载失败", e);
        }
    }

    /**
     * 核心方法：获取数据库连接
     */
    @Override
    public Connection getConnection() throws SQLException {
        // UNPOOLED 的精髓：每次都通过 DriverManager 建立全新的连接
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // ====================================================================
    // 下面这些方法都是 DataSource 接口强制要求实现的，但对于我们基础版的手写框架来说
    // 暂时用不到，所以可以直接返回 null 或者抛出不支持该操作的异常。
    // ====================================================================

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        throw new SQLException("不支持的操作");
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new SQLFeatureNotSupportedException();
    }
}