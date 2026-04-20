package lzt.mybatis;

import lzt.mybatis.mapper.CarMapper;
import lzt.mybatis.pojo.Car;
import lzt.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;
import java.util.Map;
public class CarMapperTest {

    @Test
    public void testSelectById(){
        // 1. 获取 SqlSession 对象
        SqlSession sqlSession = SqlSessionUtil.openSession();

        // 2. 获取 Mapper 接口的代理对象
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        // 3. 执行查询。我们查询 id 为 1 的记录
        Car car = mapper.selectById(1L);

        // 4. 打印结果
        System.out.println(car);

        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByIdToList(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByIdToList(3L);
        System.out.println(cars);
    }

    @Test
    public void testSelectAll(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAll();
        cars.forEach(car -> System.out.println(car));
    }

    @Test
    public void testSelectAll2(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        Car car = mapper.selectAll2();
        System.out.println(car);
    }

    @Test
    public void testSelectByIdRetMap(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        Map<String,Object> car = mapper.selectByIdRetMap(2L);
        System.out.println(car);
    }

    @Test
    public void testSelectAllRetListMap(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        List<Map<String,Object>> cars = mapper.selectAllRetListMap();
        System.out.println(cars);
    }
    @Test
    public void testSelectAllRetMap(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        Map<Long,Map<String,Object>> cars = mapper.selectAllRetMap();
        System.out.println(cars);
    }

    @Test
    public void testSelectAllByResultMap(){
        CarMapper carMapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        List<Car> cars = carMapper.selectAllByResultMap();
        System.out.println(cars);
    }

    @Test
    public void testSelectAllByMapUnderscoreToCamelCase(){
        CarMapper carMapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        List<Car> cars = carMapper.selectAllByMapUnderscoreToCamelCase();
        System.out.println(cars);
    }

    @Test
    public void testSelectTotal(){
        CarMapper carMapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        Long total = carMapper.selectTotal();
        System.out.println(total);
    }
}