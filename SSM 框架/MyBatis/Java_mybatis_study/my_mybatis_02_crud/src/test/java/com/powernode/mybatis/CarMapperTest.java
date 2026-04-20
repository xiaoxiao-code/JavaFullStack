package com.powernode.mybatis;

import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List; //导入 java.util.List 查询多条数据

public class CarMapperTest {

    @Test
    public void testInsertCar() {
        SqlSession sqlSession = null;
        try {
            // 1. 通过工具类获取会话
            sqlSession = SqlSessionUtil.openSession();

            // 2. 准备一个 Car 对象（我们要插入的数据）
            // 注意：id 是自增的，我们传 null 即可
            Car car = new Car(null, "粤B12345", "保时捷911", 120.50, "2025-10-01", "燃油车");

            // 3. 执行插入操作
            // 第一个参数是 XML 里定义的 namespace.id
            // 第二个参数就是我们刚刚 new 出来的 car 对象
            int count = sqlSession.insert("car.insertCar", car);

            System.out.println("成功插入了 " + count + " 条汽车记录！");

            // 4. 提交事务（所有的增删改操作都必须手动 commit）
            sqlSession.commit();

        } catch (Exception e) {
            if (sqlSession != null) {
                sqlSession.rollback(); // 发生异常时回滚
            }
            e.printStackTrace();
        } finally {
            // 5. 释放资源
            SqlSessionUtil.close(sqlSession);
        }
    }

    /**
     * 测试用例：根据 ID 删除汽车数据
     */
    @Test
    public void testDeleteCarById() {
        SqlSession sqlSession = null;
        try {
            // 1. 获取会话
            sqlSession = SqlSessionUtil.openSession();

            // 2. 执行删除操作
            // 第一个参数是 namespace.id
            // 第二个参数是你要删除的那个 ID (请先打开 Navicat 看一下你表里真实存在的 ID 是多少，比如我这里填 1L)
            // 注意：因为实体类里定义的是 Long 类型，所以数字后面最好加上大写字母 L
            int count = sqlSession.delete("car.deleteCarById", 11L);

            System.out.println("成功删除了 " + count + " 条汽车记录！");

            // 3. 提交事务（千万记住，增删改都必须 commit，否则数据库不会真正发生变化）
            sqlSession.commit();

        } catch (Exception e) {
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            e.printStackTrace();
        } finally {
            // 4. 释放资源
            SqlSessionUtil.close(sqlSession);
        }
    }

    /**
     * 测试用例：根据 ID 更新汽车数据
     */
    @Test
    public void testUpdateCar() {
        SqlSession sqlSession = null;
        try {
            // 1. 获取会话
            sqlSession = SqlSessionUtil.openSession();

            // 2. 准备要更新的数据对象
            // 【关键点】：必须要有 id (9L)，因为 SQL 里的 where id = #{id} 靠它来定位！
            // 其他参数填入你要求的新数据
            Car car = new Car(9L, "102", "比亚迪汉", 30.23, "2018-09-10", "电车");

            // 3. 执行修改操作
            // 第一个参数是 namespace.id
            // 第二个参数是我们封装好新数据的 car 对象
            int count = sqlSession.update("car.updateCar", car);

            System.out.println("成功修改了 " + count + " 条汽车记录！");

            // 4. 提交事务（千万记住，增删改都必须 commit！）
            sqlSession.commit();

        } catch (Exception e) {
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            e.printStackTrace();
        } finally {
            // 5. 释放资源
            SqlSessionUtil.close(sqlSession);
        }
    }

    /**
     * 测试用例：根据 ID 查询一条汽车数据
     */
    @Test
    public void testSelectCarById() {
        SqlSession sqlSession = null;
        try {
            // 1. 获取会话
            sqlSession = SqlSessionUtil.openSession();

            // 2. 执行查询操作
            // 使用 selectOne 方法：专门用来查询一条数据（如果查出多条会报错！）
            // 第一个参数是 namespace.id
            // 第二个参数是你要查询的 ID，咱们查刚才那辆 id=9 的比亚迪汉
            // 【重点】：它的返回值直接就是我们在 resultType 里配置的 Car 对象！
            Object obj = sqlSession.selectOne("car.selectCarById", 9L);

            // 将 Object 向下转型为 Car (因为我们确信 resultType 就是 Car)
            Car car = (Car) obj;

            // 3. 打印结果，看看 MyBatis 有没有帮我们把数据封装好
            System.out.println("查到的汽车信息：");
            System.out.println(car);

            //注意：查询操作只是读取数据，不会改变数据库的内容，所以【不需要】执行 sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 4. 释放资源
            SqlSessionUtil.close(sqlSession);
        }
    }

    /**
     * 测试用例：查询所有汽车数据
     */
    @Test
    public void testSelectAllCars() {
        SqlSession sqlSession = null;
        try {
            // 1. 获取会话
            sqlSession = SqlSessionUtil.openSession();

            // 2. 执行查询操作
            // 【核心区别】：这次我们调用的是 selectList 方法！
            // MyBatis 查到多条记录后，会自动生成一个 List 集合，里面装满了 Car 对象。
            List<Car> cars = sqlSession.selectList("car.selectAllCars");

            // 3. 遍历并打印结果
            System.out.println("==== 数据库中所有的汽车信息 ====");
            for (Car car : cars) {
                System.out.println(car);
            }

            // 查询操作不需要 commit

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 4. 释放资源
            SqlSessionUtil.close(sqlSession);
        }
    }

    /**
     * 测试用例：深入理解 namespace 的隔离作用
     */
    @Test
    public void testNamespace() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionUtil.openSession();

            System.out.println("==== 正在执行 car.selectAllCars ====");
            // 明确指出：我要调用 namespace 为 car 里面的 selectAllCars
            List<Car> cars1 = sqlSession.selectList("car.selectAllCars");
            for (Car car : cars1) {
                System.out.println(car);
            }

            System.out.println("\n==== 正在执行 car2.selectAllCars ====");
            // 明确指出：我要调用 namespace 为 car2 里面的 selectAllCars
            List<Car> cars2 = sqlSession.selectList("car2.selectAllCars");
            for (Car car : cars2) {
                System.out.println(car);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SqlSessionUtil.close(sqlSession);
        }
    }
}