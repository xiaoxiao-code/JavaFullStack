package org.cqipu.edu;

import org.cqipu.edu.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOASpring {
    public static void main(String[] args) {
        // 1. 创建Spring容器，加载类路径下的beans.xml配置文件
        // ClassPathXmlApplicationContext：自动从classpath（src/main/resources）加载配置
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // 2. 从容器中获取UserController对象（无需手动new，依赖已自动注入）
        UserController controller = (UserController) context.getBean("userController");

        // 3. 调用登录方法（业务逻辑完全不变）
        controller.login();
    }
}