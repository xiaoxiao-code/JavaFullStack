package lzt.lztbatis.core;

import lzt.lztbatis.mapping.LztMappedStatement;
import lzt.lztbatis.transaction.TransactionManager;
import java.util.Map;

/**
 * 默认的 SqlSessionFactory 实现类
 */
public class LztDefaultSqlSessionFactory implements SqlSessionFactory {

    /**
     * 事务管理器
     * 里面包含了数据源，负责获取数据库连接以及控制事务提交/回滚
     */
    private TransactionManager transactionManager;

    /**
     * 存放所有的 SQL 语句映射信息
     * Key: SQL 标签的唯一标识 (例如 "insertCar")
     * Value: 封装了具体 SQL 语句和返回类型的 LztMappedStatement 对象
     */
    private Map<String, LztMappedStatement> mappedStatements;

    private LztConfiguration configuration;

    /**
     * 构造方法：在工厂被实例化时，注入事务管理器和 SQL 映射集合
     */
    public LztDefaultSqlSessionFactory(TransactionManager transactionManager, Map<String, LztMappedStatement> mappedStatements) {
        this.transactionManager = transactionManager;
        this.mappedStatements = mappedStatements;
    }

    /**
     * 构造方法：在工厂被实例化时，直接注入配置大管家
     */
    public LztDefaultSqlSessionFactory(LztConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        // 【核心逻辑】
        // 当用户调用 factory.openSession() 时，实际上是去 new 一个具体的 SqlSession 对象。
        // 我们把大管家交给新创建的 Session，让它具备执行 SQL 和控制事务的能力。
        return new LztDefaultSqlSession(this.configuration);
    }


    // --- Getter 和 Setter 方法 ---

    public LztConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(LztConfiguration configuration) {
        this.configuration = configuration;
    }

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