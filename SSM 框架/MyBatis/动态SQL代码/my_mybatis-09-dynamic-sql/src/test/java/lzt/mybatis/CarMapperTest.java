package lzt.mybatis;
import lzt.mybatis.mapper.CarMapper;
import lzt.mybatis.pojo.Car;
import lzt.mybatis.utils.SqlSessionUtil;
import org.junit.Test;
import java.util.List;
import java.util.Arrays;

public class CarMapperTest {
    @Test
    public void testSelectByMultiCondition(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByMultiCondition("宝马", 41.0, "燃油车");
        // List<Car> cars = mapper.selectByMultiCondition("", 41.0, "燃油车");
        // List<Car> cars = mapper.selectByMultiCondition("", null, "");
        System.out.println(cars);
    }

    @Test
    public void testSelectByMultiConditionWithWhere(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        // List<Car> cars = mapper.selectByMultiConditionWithWhere("宝马", 41.0, "燃油车");
        // List<Car> cars = mapper.selectByMultiConditionWithWhere("", null, "");
        List<Car> cars = mapper.selectByMultiConditionWithWhere("宝马", 41.0, "");
        System.out.println(cars);
    }
    @Test
    public void testSelectByMultiConditionWithTrim(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        // List<Car> cars = mapper.selectByMultiConditionWithTrim("宝马", 41.0, "");
        List<Car> cars = mapper.selectByMultiConditionWithTrim("", null, "");
        System.out.println(cars);
    }

    @Test
    public void testUpdateWithSet(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        Car car = new Car(3L,"102","丰田未来",40.30,"",null);
        int count = mapper.updateWithSet(car);
        System.out.println(count);
        SqlSessionUtil.openSession().commit();
    }

    @Test
    public void testSelectWithChoose(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        //List<Car> cars = mapper.selectWithChoose("宝马520Li", 41.0, "2022-09-01");
        //List<Car> cars = mapper.selectWithChoose("", 41.0, "2022-09-01");
        //List<Car> cars = mapper.selectWithChoose("", null, "2022-09-01");
        List<Car> cars = mapper.selectWithChoose("", null, "");
        System.out.println(cars);
    }

    @Test
    public void testDeleteBatchByForeach(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        int count = mapper.deleteBatchByForeach(new Long[]{9L, 10L, 29L});
        System.out.println("删除了几条记录：" + count);
        SqlSessionUtil.openSession().commit();
    }

    @Test
    public void testDeleteBatchByForeach2(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        int count = mapper.deleteBatchByForeach2(new Long[]{6L, 7L, 8L});
        System.out.println("删除了几条记录：" + count);
        SqlSessionUtil.openSession().commit();
    }

    @Test
    public void testInsertBatchByForeach(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        Car car1 = new Car(null, "2001", "兰博基尼", 100.0, "1998-10-11", "燃油车");
        Car car2 = new Car(null, "2001", "兰博基尼", 100.0, "1998-10-11", "燃油车");
        Car car3 = new Car(null, "2001", "兰博基尼", 100.0, "1998-10-11", "燃油车");
        List<Car> cars = Arrays.asList(car1, car2, car3);
        int count = mapper.insertBatchByForeach(cars);
        System.out.println("插入了几条记录" + count);
        SqlSessionUtil.openSession().commit();
    }
}


