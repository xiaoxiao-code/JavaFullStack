package lzt.lztbatis.utils;

import java.io.InputStream;

/**
 * lztBatis 框架提供的工具类
 * 专门用于从类路径中加载资源文件
 */
public class Resources {

    /**
     * 工具类的构造方法建议私有化，防止在外部被 new 出来
     */
    private Resources() {}

    /**
     * 从类路径中加载资源，返回一个输入流
     * @param resource 资源名称（例如："mybatis-config.xml"）
     * @return InputStream 输入流
     */
    public static InputStream getResourceAsStream(String resource) {
        // 获取当前线程的类加载器，去类路径下查找资源并返回输入流
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);

        // 另一种写法也可以：
        // return ClassLoader.getSystemClassLoader().getResourceAsStream(resource);
    }
}