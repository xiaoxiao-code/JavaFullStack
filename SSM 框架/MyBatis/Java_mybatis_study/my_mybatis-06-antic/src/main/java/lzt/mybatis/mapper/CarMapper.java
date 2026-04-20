package lzt.mybatis.mapper;

import lzt.mybatis.pojo.Car;
import java.util.List;

/**
 * Car的sql映射对象
 */
public interface CarMapper {

    /**
     * 根据car_type获取Car
     * @param carType 汽车类型
     * @return 汽车集合
     */
    List<Car> selectByCarType(String carType);

    /**
     * 查询所有的Car并按指定规则排序
     * @param ascOrDesc asc或desc
     * @return 汽车集合
     */
    List<Car> selectAll(String ascOrDesc);

    /**
     * 根据表名查询所有的Car ( ${} 动态拼接表名)
     * @param tableName 表名
     * @return 汽车集合
     */
    List<Car> selectAllByTableName(String tableName);
    /**
     * 根据id批量删除车辆 (演示 ${} 在 in 语句中的应用)
     * @param ids 逗号分隔的多个id字符串
     * @return 受影响的行数
     */
    int deleteBatch(String ids);

    /**
     * 根据品牌进行模糊查询
     * @param brand 品牌关键字
     * @return 汽车集合
     */
    List<Car> selectLikeByBrand(String brand);

    /**
     * 根据品牌模糊查询 (使用 concat 函数 + #{})
     * @param brand 品牌
     * @return 汽车集合
     */
    List<Car> selectLikeByBrandByConcat(String brand);

    /**
     * 根据品牌模糊查询 (使用 双引号拼接 + #{})
     * @param brand 品牌
     * @return 汽车集合
     */
    List<Car> selectLikeByBrandByQuote(String brand);

    /**
     * 新增Car，并获取自动生成的主键
     * @param car 汽车对象
     * @return 受影响的行数（注意：返回的不是主键ID！）
     */
    int insertUseGeneratedKeys(Car car);
}