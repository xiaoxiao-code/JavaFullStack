package lzt.mybatis.test;

import lzt.mybatis.mapper.CarMapper;
import lzt.mybatis.pojo.Car;
import lzt.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

import java.util.List;

/**
 * CarMapper测试类
 */
public class CarMapperTest {

    @Test
    public void testSelectByCarType(){
        // 获取 Mapper 的代理对象
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);

        // 调用方法，测试 #{} 传值
        List<Car> cars = mapper.selectByCarType("燃油车");

        // 遍历输出结果
        cars.forEach(car -> System.out.println(car));

        // 记得关闭会话
        SqlSessionUtil.close(SqlSessionUtil.openSession());
    }

    @Test
    public void testSelectAll(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        // 尝试传入 desc 进行降序排列
        List<Car> cars = mapper.selectAll("desc");
        cars.forEach(car -> System.out.println(car));

        // 关闭会话
        SqlSessionUtil.close(SqlSessionUtil.openSession());
    }

    @Test
    public void testSelectAllByTableName(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);

        // 动态传入表名 t_car
        List<Car> cars = mapper.selectAllByTableName("t_car");
        cars.forEach(car -> System.out.println(car));

        // 释放资源
        SqlSessionUtil.close(SqlSessionUtil.openSession());
    }

    @Test
    public void testDeleteBatch(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);

        // 传入从 12 到 28 逗号分隔的字符串
        String idsToDelete = "12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28";
        int count = mapper.deleteBatch(idsToDelete);

        System.out.println("删除了几条记录：" + count);

        // 执行了增删改操作，一定要记得 commit 提交事务！
        SqlSessionUtil.openSession().commit();
        // 释放资源
        SqlSessionUtil.close(SqlSessionUtil.openSession());
    }

    @Test
    public void testSelectLikeByBrand(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);

        // 传入关键字进行模糊查询
        List<Car> cars = mapper.selectLikeByBrand("丰田");
        cars.forEach(car -> System.out.println(car));

        // 记得释放资源
        SqlSessionUtil.close(SqlSessionUtil.openSession());
    }

    @Test
    public void testSelectLikeByBrandByConcat(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);

        List<Car> cars = mapper.selectLikeByBrandByConcat("丰田");
        cars.forEach(car -> System.out.println(car));

        SqlSessionUtil.close(SqlSessionUtil.openSession());
    }

    @Test
    public void testSelectLikeByBrandByQuote(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);

        List<Car> cars = mapper.selectLikeByBrandByQuote("丰田");
        cars.forEach(car -> System.out.println(car));

        SqlSessionUtil.close(SqlSessionUtil.openSession());
    }

    @Test
    public void testInsertUseGeneratedKeys(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);

        // 1. 创建一个全新的 Car 对象，此时它的 id 是 null
        Car car = new Car();
        car.setCarNum("5262");
        car.setBrand("BYD汉");
        car.setGuidePrice(30.3);
        car.setProduceTime("2020-10-11");
        car.setCarType("新能源");

        System.out.println("插入前，car的id是：" + car.getId()); // 这里打印肯定是 null

        // 2. 执行插入操作
        mapper.insertUseGeneratedKeys(car);

        // 3. 提交事务（增删改必写！）
        SqlSessionUtil.openSession().commit();

        // 4. 见证奇迹的时刻：MyBatis 已经悄悄把数据库生成的新 ID 塞进了这个 car 对象里！
        System.out.println("插入后，自动生成的主键id是：" + car.getId());

        // 5. 释放资源
        SqlSessionUtil.close(SqlSessionUtil.openSession());
    }
}