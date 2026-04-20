package lzt.lztbatis.transaction;

import java.sql.Connection;

/**
 * 事务管理器接口
 * 负责规范数据库事务的核心行为
 */
public interface TransactionManager {

    /**
     * 获取数据库连接
     */
    Connection getConnection();

    /**
     * 提交事务
     */
    void commit();

    /**
     * 回滚事务
     */
    void rollback();

    /**
     * 关闭连接，释放资源
     */
    void close();
}