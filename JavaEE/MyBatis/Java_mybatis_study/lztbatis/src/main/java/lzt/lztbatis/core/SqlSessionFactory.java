package lzt.lztbatis.core;

/**
 * SqlSession 工厂接口
 * 核心职责：生产与数据库交互的 SqlSession 对象
 */
public interface SqlSessionFactory {

    /**
     * 开启并获取一个数据库会话
     * @return SqlSession 对象
     */
    SqlSession openSession();
}

