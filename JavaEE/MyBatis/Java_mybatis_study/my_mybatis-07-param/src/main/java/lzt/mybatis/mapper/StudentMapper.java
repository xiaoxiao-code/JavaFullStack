package lzt.mybatis.mapper;
import lzt.mybatis.pojo.Student;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
/**
 * 学生数据Sql映射器
 * 演示：单个简单类型参数的多种情况
 */
public interface StudentMapper {
    /**
     * 根据name查询 (String类型)
     * @param name
     * @return
     */
    List<Student> selectByName(String name);

    /**
     * 根据id查询 (Long类型包装类)
     * @param id
     * @return
     */
    Student selectById(Long id);

    /**
     * 根据birth查询 (Date类型)
     * @param birth
     * @return
     */
    List<Student> selectByBirth(Date birth);

    /**
     * 根据sex查询 (Character类型)
     * @param sex
     * @return
     */
    List<Student> selectBySex(Character sex);

    /**
     * 根据name和age查询 (演示 Map 传参)
     * @param paramMap 封装了查询条件的 Map 集合
     * @return 返回查询到的学生列表
     */
    List<Student> selectByParamMap(Map<String, Object> paramMap);

    /**
     * 保存学生数据
     * @param student
     * @return
     */
    int insert(Student student);

    /**
     * 根据name和sex查询
     * @param name
     * @param sex
     * @return
     */
    List<Student> selectByNameAndSex(String name, Character sex);

    /**
     * 根据name和age查询
     * @param name
     * @param age
     * @return
     */
    List<Student> selectByNameAndAge(@Param(value="name") String name, @Param("age") int age);
}