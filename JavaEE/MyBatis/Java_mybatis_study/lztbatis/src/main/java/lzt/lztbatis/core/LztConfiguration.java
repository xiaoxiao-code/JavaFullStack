package lzt.lztbatis.core;

import lzt.lztbatis.mapping.LztMappedStatement;
import lzt.lztbatis.transaction.TransactionManager;

import java.util.Map;

/**
 * lztBatis 框架的核心配置类
 * 专门用于在内存中存放整个框架运行期间需要的所有配置信息
 */
public class LztConfiguration {

    /**
     * 事务管理器（内部已经封装了 DataSource 数据源）
     * 对应 mybatis-config.xml 中的 <environments> 标签解析结果
     */
    private TransactionManager transactionManager;

    /**
     * 所有的 SQL 映射语句集合
     * Key: SQL 语句的 id（例如 "insertCar"）
     * Value: 具体的映射语句对象（包含了 sql 和 resultType）
     * 对应所有的 Mapper XML 文件的解析结果
     */
    private Map<String, LztMappedStatement> mappedStatements;

    /**
     * 构造方法
     */
    public LztConfiguration() {
    }

    public LztConfiguration(TransactionManager transactionManager, Map<String, LztMappedStatement> mappedStatements) {
        this.transactionManager = transactionManager;
        this.mappedStatements = mappedStatements;
    }

    // --- Getter 和 Setter 方法 ---

    public TransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public Map<String, LztMappedStatement> getMappedStatements() {
        return mappedStatements;
    }

    public void setMappedStatements(Map<String, LztMappedStatement> mappedStatements) {
        this.mappedStatements = mappedStatements;
    }
}