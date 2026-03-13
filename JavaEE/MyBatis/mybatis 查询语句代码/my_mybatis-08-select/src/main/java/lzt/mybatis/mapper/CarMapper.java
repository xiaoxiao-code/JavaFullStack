package lzt.mybatis.mapper;
import java.util.List;
import lzt.mybatis.pojo.Car;
import java.util.Map;
import org.apache.ibatis.annotations.MapKey;
/**
 * Car SQL映射器接口
 * 重点关注：当查询结果只有一条时，方法的返回值类型直接写对应的 POJO 类。
 */
public interface CarMapper {

    /**
     * 根据id主键查询：结果最多只有一条
     * @param id 汽车的主键
     * @return 封装好的 Car 对象
     */
    Car selectById(Long id);

    /**
     * 根据id主键查询：结果最多只有一条，可以放到List集合中吗？
     * @return
     */
    List<Car> selectByIdToList(Long id);

    /**
     * 查询所有的Car
     * @return
     */
    List<Car> selectAll();

    /**
     * 查询多条记录，采用单个实体类接收会怎样？
     * @return
     */
    Car selectAll2();

    /**
     * 通过id查询一条记录，返回Map集合
     * @param id
     * @return
     */
    Map<String, Object> selectByIdRetMap(Long id);

    /**
     * 查询所有的Car，返回一个List集合。List集合中存储的是Map集合。
     * @return
     */
    List<Map<String,Object>> selectAllRetListMap();

    /**
     * 获取所有的Car，返回一个Map集合。
     * Map集合的key是Car的id。
     * Map集合的value是对应Car。
     * @return
     */
    @MapKey("id")
    Map<Long,Map<String,Object>> selectAllRetMap();

    /**
     * 查询所有Car，使用resultMap进行结果映射
     * @return
     */
    List<Car> selectAllByResultMap();

    /**
     * 查询所有Car，启用驼峰命名自动映射
     * @return
     */
    List<Car> selectAllByMapUnderscoreToCamelCase();

    /**
     * 获取总记录条数
     * @return
     */
    Long selectTotal();
}