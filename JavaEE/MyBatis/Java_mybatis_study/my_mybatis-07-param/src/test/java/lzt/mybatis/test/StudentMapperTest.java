package lzt.mybatis.test;

import lzt.mybatis.mapper.StudentMapper;
import lzt.mybatis.pojo.Student;
import lzt.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import java.util.HashMap;
import java.util.Map;

public class StudentMapperTest {

    // 获取 Mapper 接口的代理对象
    StudentMapper mapper = SqlSessionUtil.openSession().getMapper(StudentMapper.class);

    @Test
    public void testSelectByName(){
        List<Student> students = mapper.selectByName("张三");
        students.forEach(student -> System.out.println(student));
    }

    @Test
    public void testSelectById(){
        Student student = mapper.selectById(2L);
        System.out.println(student);
    }

    @Test
    public void testSelectByBirth(){
        try {
            // String 转换成 Date
            Date birth = new SimpleDateFormat("yyyy-MM-dd").parse("2022-08-16");
            List<Student> students = mapper.selectByBirth(birth);
            students.forEach(student -> System.out.println(student));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testSelectBySex(){
        List<Student> students = mapper.selectBySex('男');
        students.forEach(student -> System.out.println(student));
    }

    @Test
    public void testSelectByParamMap(){
        // 1. 准备 Map 集合，把参数封装进去
        Map<String, Object> paramMap = new HashMap<>();

        // 老杜再次强调：这里的 "nameKey" 和 "ageKey"，就是 XML 里面 #{} 要抓取的标识符！
        paramMap.put("nameKey", "张三");
        paramMap.put("ageKey", 20);

        // 2. 调用接口方法，把 Map 这个大包裹传过去
        List<Student> students = mapper.selectByParamMap(paramMap);

        // 3. 打印结果
        students.forEach(student -> System.out.println(student));
    }

    @Test
    public void testInsert(){
        Student student = new Student();
        student.setName("李四");
        student.setAge(30);
        student.setHeight(1.70);
        student.setSex('男');
        student.setBirth(new Date());
        int count = mapper.insert(student);
        SqlSessionUtil.openSession().commit();
    }
    @Test
    public void testSelectByNameAndSex(){
        List<Student> students = mapper.selectByNameAndSex("张三", '女');
        students.forEach(student -> System.out.println(student));
    }

    @Test
    public void testSelectByNameAndAge(){
        List<Student> stus = mapper.selectByNameAndAge("张三", 20);
        stus.forEach(student -> System.out.println(student));
    }
}