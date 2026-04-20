package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.utils.SqlSessionUtil; // 导入刚刚写的工具类
import org.junit.Test;

import java.util.List;

/**
 * 汽车数据访问层（Mapper）的单元测试
 */
public class CarMapperTest {

    /**
     * 测试用例 1：测试插入汽车数据
     */
    @Test
    public void testInsertCar() {
        SqlSession sqlSession = null;
        try {
            // 【改造点 1】不再需要手动 build 工厂，直接一行代码获取当前线程的 SqlSession！
            sqlSession = SqlSessionUtil.openSession();

            // 执行SQL
            int count = sqlSession.insert("car.insertCar");
            System.out.println("更新了几条记录：" + count);

            // 提交事务 (增删改必须提交)
            sqlSession.commit();
        } catch (Exception e) {
            // 回滚事务，保证数据一致性
            if (sqlSession != null) {
                sqlSession.rollback();
                System.out.println("发生异常，事务已回滚！");
            }
            e.printStackTrace();
        } finally {
            // 【改造点 2】使用工具类的 close 方法，安全释放资源并清理 ThreadLocal
            SqlSessionUtil.close(sqlSession);
        }
    }

    /**
     * 测试用例 2：测试查询所有汽车数据
     */
    @Test
    public void testSelectAllCars() {
        SqlSession sqlSession = null;
        try {
            // 【改造点 1】同样，一行代码搞定！
            sqlSession = SqlSessionUtil.openSession();

            // 执行查询 SQL
            List<Object> cars = sqlSession.selectList("car.selectAllCars");

            System.out.println("==== 查询到的汽车列表 ====");
            for (Object car : cars) {
                System.out.println(car);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 【改造点 2】安全释放
            SqlSessionUtil.close(sqlSession);
        }
    }
}