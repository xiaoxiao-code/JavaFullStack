package lzt.mybatis;

import lzt.mybatis.mapper.StudentMapper;
import lzt.mybatis.pojo.Student;
import lzt.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

public class StudentMapperTest {

    @Test
    public void testSelectBySid(){
        // 获取 Mapper 接口的代理对象
        StudentMapper mapper = SqlSessionUtil.openSession().getMapper(StudentMapper.class);
        // 执行查询，查询 sid 为 1 的学生（张三）
        Student student = mapper.selectBySid(1);
        // 打印结果，你应该能看到张三的信息以及他所属的高三1班的信息
//        System.out.println(student);
        // 只获取学生名字
        String sname = student.getSname();
        System.out.println("学生姓名：" + sname);

        // 到这里之后，想获取班级名字了
        String cname = student.getClazz().getCname();
        System.out.println("学生的班级名称：" + cname);
    }
}