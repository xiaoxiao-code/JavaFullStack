package lzt.mybatis.mapper;
import lzt.mybatis.pojo.Student;
import java.util.List;

public interface StudentMapper {
    /**
     * 根据学生 id 查询学生信息，并同时查询出其所属的班级信息
     * @param sid 学生编号
     * @return 包含班级信息的学生对象
     */
    Student selectBySid(Integer sid);

    /**
     * 根据班级编号获取所有的学生。
     * @param cid
     * @return
     */
    List<Student> selectByCid(Integer cid);
}