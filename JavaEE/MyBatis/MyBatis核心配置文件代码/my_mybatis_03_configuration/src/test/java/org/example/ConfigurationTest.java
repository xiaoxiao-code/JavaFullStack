package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.pojo.Car;
import org.junit.Test;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import java.io.InputStream;

public class ConfigurationTest {

    @Test
    public void testEnvironment() throws Exception {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        // 测试 1：使用默认环境 (dev)
        InputStream is1 = Resources.getResourceAsStream("mybatis-config.xml");
        // 不传第二个参数，读取 XML 里的 default="dev"
        SqlSessionFactory factoryDev = builder.build(is1);
        SqlSession sessionDev = factoryDev.openSession();

        Car car1 = new Car(null, "DEV-001", "程序员本地自测车", 10.0, "2026-01-01", "燃油车");
        sessionDev.insert("car.insertCar", car1);
        sessionDev.commit();
        sessionDev.close();
        System.out.println("成功：已经向【开发库 mybatis_demo】插入了一条数据！");

        // 测试 2：强制切换到测试环境 (test)
        InputStream is2 = Resources.getResourceAsStream("mybatis-config.xml");
        // 传入 "test"，强制激活测试环境
        SqlSessionFactory factoryTest = builder.build(is2, "test");
        SqlSession sessionTest = factoryTest.openSession();

        Car car2 = new Car(null, "TEST-002", "测试组找Bug专用车", 20.0, "2026-02-02", "电车");
        sessionTest.insert("car.insertCar", car2);
        sessionTest.commit();
        sessionTest.close();
        System.out.println("成功：已经向【测试库 mybatis_test】插入了一条数据！");

        // 测试 3：强制切换到生产环境 (prod)
        InputStream is3 = Resources.getResourceAsStream("mybatis-config.xml");
        // 传入 "prod"，强制激活生产环境
        SqlSessionFactory factoryProd = builder.build(is3, "prod");
        SqlSession sessionProd = factoryProd.openSession();

        Car car3 = new Car(null, "PROD-003", "真实用户购买的量产车", 30.0, "2026-03-03", "氢能源");
        sessionProd.insert("car.insertCar", car3);
        sessionProd.commit();
        sessionProd.close();
        System.out.println("成功：已经向【生产库 mybatis_prod】插入了一条数据！");
    }

    /**
     * 测试用例：验证 MANAGED 事务管理器的“甩手掌柜”行为
     */
    @Test
    public void testTransactionManager() throws Exception {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        // 【关键】：这里读取的是我们刚刚新建的 mybatis-config2.xml
        InputStream is = Resources.getResourceAsStream("mybatis-config2.xml");
        SqlSessionFactory factory = builder.build(is);
        SqlSession session = factory.openSession();

        // 准备一辆特征极其明显的测试车
        Car car = new Car(null, "MANAGED-999", "MANAGED测试车", 99.9, "2026-10-10", "燃油车");

        // 执行插入操作
        int count = session.insert("car.insertCar", car);
        System.out.println("代码执行情况：成功执行了 insert SQL，MyBatis 告诉你影响了 " + count + " 行数据。");

        // 【重头戏】：我们老老实实地手写了 commit 提交事务
        session.commit();
        System.out.println("代码执行情况：已经调用了 session.commit()。");

        // 释放资源
        session.close();

        System.out.println("=============================================");
        System.out.println("请现在打开 Navicat，刷新 mybatis_demo 库的 t_car 表！");
        System.out.println("看看那辆叫 'MANAGED-999' 的车真的存进去了吗？");
    }
    /**
     * 测试用例：验证 UNPOOLED 数据源的底层行为
     */
    @Test
    public void testDataSource() throws Exception {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream is = Resources.getResourceAsStream("mybatis-config3.xml");
        SqlSessionFactory factory = builder.build(is);

        System.out.println("================ 第一次执行 SQL ================");
        SqlSession session1 = factory.openSession();
        Car car1 = new Car(null, "UNPOOLED-01", "非连接池测试车1", 10.0, "2026-04-01", "燃油车");
        session1.insert("car.insertCar", car1);
        session1.commit();
        session1.close(); // 关闭会话

        System.out.println("\n================ 第二次执行 SQL ================");
        SqlSession session2 = factory.openSession();
        Car car2 = new Car(null, "UNPOOLED-02", "非连接池测试车2", 20.0, "2026-04-02", "燃油车");
        session2.insert("car.insertCar", car2);
        session2.commit();
        session2.close(); // 再次关闭会话
    }

    /**
     * 测试用例：极限压测，亲眼见证 POOLED 连接池的高级管理机制
     */
    @Test
    public void testPool() throws Exception {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream is = Resources.getResourceAsStream("mybatis-config4.xml");
        SqlSessionFactory factory = builder.build(is);

        // 准备一个 List，用来“扣留”拿到的会话，防止它们被垃圾回收或自动归还
        List<SqlSession> activeSessions = new ArrayList<>();

        System.out.println("=========== 第一阶段：测试最大活跃数 ===========");
        try {
            // 我们的池子最大活跃数(Active)设为了 3。我们故意循环 4 次去拿！
            for (int i = 1; i <= 4; i++) {
                System.out.println("尝试获取第 " + i + " 个连接...");
                SqlSession session = factory.openSession();

                // 【核心强硬手段】：强行调用 getConnection()，逼 MyBatis 马上从池子里拿出一个真实的物理连接！
                session.getConnection();

                // 把连接扣留下来，坚决不调用 session.close()
                activeSessions.add(session);
                System.out.println("第 " + i + " 个连接获取成功！当前池子已被占用 " + i + " 个。\n");
            }
        } catch (Exception e) {
            System.out.println("\n触发连接池防御机制！拿不到第 4 个连接了！");
            System.out.println("报错原因：" + e.getMessage());
        }

        System.out.println("\n=========== 第二阶段：测试回收机制 ===========");
        // 现在池子是被榨干的，我们把之前扣留的 3 个连接全部归还
        for (int i = 0; i < activeSessions.size(); i++) {
            System.out.println("准备归还第 " + (i + 1) + " 个连接...");
            // 调用 close()，对于 POOLED 来说，这就是把连接洗干净放回池子
            activeSessions.get(i).close();
        }
        System.out.println("所有连接已成功归还！");
    }
    /**
     * 测试用例：验证 properties 标签是否成功读取了外部配置文件
     */
    @Test
    public void testProperties() throws Exception {
        // 1. 获取建造者
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        // 2. 读取刚刚写好的 mybatis-config5.xml
        InputStream is = Resources.getResourceAsStream("mybatis-config5.xml");
        SqlSessionFactory factory = builder.build(is);

        // 3. 打开会话
        SqlSession session = factory.openSession();

        System.out.println("成功加载 mybatis-config5.xml，即将测试数据库连接...");

        // 4. 复用上一次写的按车牌号查询的 SQL 语句来验证连接是否通畅
        // 注意：请将 "102" 替换为你数据库里真实存在的车牌号，否则查出来是个空集合
        java.util.List<Car> cars = session.selectList("car2.selectCarByCarNum", "102");

        System.out.println("==== 查询成功，证明外部 jdbc.properties 加载完美！ ====");
        for (Car car : cars) {
            System.out.println(car);
        }

        // 5. 释放资源
        session.close();
    }
}