package org.cqipu.edu;
import org.cqipu.edu.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.lang.reflect.InvocationTargetException;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.cqipu.edu.bean.Vip;
public class Spring6Test {

    @Test
    public void testFirst01(){
        // 初始化Spring容器上下文（解析beans.xml文件，创建所有的bean对象）
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        // 根据id获取bean对象
        Object userBean = applicationContext.getBean("userBean");
        System.out.println(userBean);
    }

    @Test
    public void testFirst() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 1. 通过反射手动创建User对象
        Class<?> clazz = Class.forName("org.cqipu.edu.bean.User"); // 加载User类
        Object obj = clazz.getDeclaredConstructor().newInstance(); // 调用无参构造创建实例
        System.out.println("手动反射创建的User对象：" + obj);

        // 2. 通过Spring IoC容器创建User对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml"); // 初始化Spring容器，加载配置文件
        Object userBean = applicationContext.getBean("userBean"); // 从容器获取名为userBean的Bean
        System.out.println("Spring容器创建的User对象：" + userBean);
    }

    @Test
    public void testFirst02(){
        // 初始化Spring容器上下文（解析beans.xml文件，创建所有的bean对象）
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml","spring.xml");

        // 根据id获取bean对象
        Object userBean = applicationContext.getBean("userBean");
        Object vipBean = applicationContext.getBean("vipBean");
        Object dateBean = applicationContext.getBean("dateBean");

        System.out.println(userBean);
        System.out.println(vipBean);
        System.out.println(dateBean);
    }

    @Test
    public void testBeanType() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        // 新写法：无需转型，类型安全
        User user = ctx.getBean("userBean", User.class);
        // 直接调用User的特有方法/属性（无编译警告、无运行时转型风险）
        user.setUsername("admin");
        user.setPassword("123456");
        System.out.println(user.getUsername()); // 直接访问子类特有属性

        // 旧写法：需手动转型，类型不安全
        Object userObj = ctx.getBean("userBean");
        User userOld = (User) userObj; // 编译期无检查，易出错
    }

    @Test
    public void testFileSystemXml() throws Exception {
        // 1. 填写 Spring6.xml 的绝对磁盘路径
        // 根据目录树，Spring6.xml 实际位置：
        // D:\java_Spring6_study\spring6-first-demo02\src\main\java\Spring6.xml
        ApplicationContext applicationContext2 = new FileSystemXmlApplicationContext(
                "D:/java_Spring6_study/spring6-first-demo02/src/main/java/Spring6.xml"
        );
        // 2. 从容器中获取 Vip Bean
        Vip vip = applicationContext2.getBean("vipBean2", Vip.class);

        // 3. 输出结果
        System.out.println("从文件系统加载 XML 成功，Vip 对象：" + vip);
    }

    @Test
    public void testBeanFactory() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring.xml");

        // 2. 方式1：基础写法 - 返回 Object 类型，需手动转型
        Object vipBean = beanFactory.getBean("vipBean");
        System.out.println("BeanFactory 获取 Object 类型 Vip：" + vipBean);

        // 3. 方式2：推荐写法 - 指定类型，无需转型（BeanFactory 也支持泛型重载方法）
        Vip vip = beanFactory.getBean("vipBean", Vip.class);
        System.out.println("BeanFactory 获取 Vip 类型对象：" + vip);
    }
}