package lzt.lztbatis.core;

/**
 * 核心会话接口
 * 提供了执行 SQL、提交、回滚和关闭会话的方法
 */
public interface SqlSession {

    /**
     * 执行插入操作
     * @param sqlId SQL 语句的唯一标识
     * @param pojo  要插入的实体类对象
     * @return 影响的行数
     */
    int insert(String sqlId, Object pojo);

    /**
     * 执行查询单条记录的操作
     * @param sqlId SQL 语句的唯一标识
     * @param parameter 查询参数
     * @return 查询到的结果对象
     */
    Object selectOne(String sqlId, Object parameter);

    /**
     * 提交事务
     */
    void commit();

    /**
     * 回滚事务
     */
    void rollback();

    /**
     * 关闭会话（释放连接）
     */
    void close();
}