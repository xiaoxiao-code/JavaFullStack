package org.cqipu.edu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cqipu.edu.bean.Vip;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring6BeanFactoryTest {

    // 1. 获取 Log4j2 日志对象
    private static final Logger logger = LogManager.getLogger(Spring6BeanFactoryTest.class);

    @Test
    public void testBeanFactory() {
        // 2. 输出不同级别日志
        logger.info("===== 开始初始化 Spring 容器 =====");
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring.xml");

        logger.debug("容器初始化完成，开始获取 Vip Bean"); // debug级别
        Vip vip = beanFactory.getBean("vipBean", Vip.class);

        logger.info("成功获取 Vip Bean：{}", vip); // 占位符输出对象
        logger.warn("测试警告级别日志");
    }
}