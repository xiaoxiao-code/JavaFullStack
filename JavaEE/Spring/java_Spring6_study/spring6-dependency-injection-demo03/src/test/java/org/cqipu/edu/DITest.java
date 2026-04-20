package org.cqipu.edu;
import org.cqipu.edu.bean.*;
import org.cqipu.edu.bean.Math;
import org.cqipu.edu.service.AccountService;
import org.cqipu.edu.service.UserService;
import org.cqipu.edu.service.OrderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DITest {

    @Test
    public void testSetDI(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = applicationContext.getBean("userServiceBean", UserService.class);
//        userService.save();
    }

    @Test
    public void testConstructorDI(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        OrderService orderServiceBean = applicationContext.getBean("orderServiceBean", OrderService.class);
        orderServiceBean.delete();
    }

    @Test
    public void testInnerBean(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-inner-bean.xml");
        UserService userService = applicationContext.getBean("userServiceBean", UserService.class);
//        userService.save();
    }

    @Test
    public void testSimpleType(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-simple-type.xml");
        User user = applicationContext.getBean("userBean", User.class);
        System.out.println(user);
    }

    @Test
    public void testDataSource(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-datasource.xml");
        MyDataSource dataSource = applicationContext.getBean("dataSource", MyDataSource.class);
        System.out.println(dataSource);
    }

    @Test
    public void testAllSimpleType(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-all-simple-type.xml");
        A a = applicationContext.getBean("a", A.class);
        System.out.println(a);
    }

    @Test
    public void testCascade(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-cascade.xml");
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student);
    }

    @Test
    public void testArraySimple(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-array-simple.xml");
        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person);
    }

    @Test
    public void testArray(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-array.xml");
        Order order = applicationContext.getBean("order", Order.class);
        System.out.println(order);
    }

    @Test
    public void testCollection(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-collection.xml");
        People peopleBean = applicationContext.getBean("peopleBean", People.class);
        System.out.println(peopleBean);
    }

    @Test
    public void testCollection02(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-collection01.xml");
        People peopleBean = applicationContext.getBean("peopleBean", People.class);
        System.out.println(peopleBean);
    }

    @Test
    public void testNull(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-null.xml");
        Vip vipBean = applicationContext.getBean("vipBean", Vip.class);
        System.out.println(vipBean);
    }

    @Test
    public void testSpecial(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-special.xml");
        Math mathBean = applicationContext.getBean("mathBean", Math.class);
        System.out.println(mathBean);
    }

    @Test
    public void testP(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-p.xml");
        Customer customerBean = applicationContext.getBean("customerBean", Customer.class);
        System.out.println(customerBean);
    }

    @Test
    public void testC(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-c.xml");
        MyTime myTimeBean = applicationContext.getBean("myTimeBean", MyTime.class);
        System.out.println(myTimeBean);
    }

    @Test
    public void testUtil(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-util.xml");

        MyDataSource1 dataSource1 = applicationContext.getBean("dataSource1", MyDataSource1.class);
        System.out.println(dataSource1);

        MyDataSource2 dataSource2 = applicationContext.getBean("dataSource2", MyDataSource2.class);
        System.out.println(dataSource2);
    }

    @Test
    public void testAutowireByName(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowire.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.save();
    }
    @Test
    public void testAutowireByType(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowire01.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        accountService.save();
    }
    @Test
    public void testProperties(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-properties.xml");
        MyDataSource dataSource = applicationContext.getBean("dataSource", MyDataSource.class);
        System.out.println(dataSource);
    }

    @Test
    public void testScope(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");

        SpringBean sb1 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb1);

        SpringBean sb2 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb2);
    }

    @Test
    public void testCustomScope(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");
        SpringBean sb1 = applicationContext.getBean("sb", SpringBean.class);
        SpringBean sb2 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb1);
        System.out.println(sb2);
        // 启动线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                SpringBean a = applicationContext.getBean("sb", SpringBean.class);
                SpringBean b = applicationContext.getBean("sb", SpringBean.class);
                System.out.println(a);
                System.out.println(b);
            }
        }).start();
    }
}
