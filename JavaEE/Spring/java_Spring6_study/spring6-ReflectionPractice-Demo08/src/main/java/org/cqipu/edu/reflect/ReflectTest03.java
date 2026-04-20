package org.cqipu.edu.reflect;
import java.lang.reflect.Method;

public class ReflectTest03 {
    public static void main(String[] args) throws Exception{
        Class clazz = Class.forName("org.cqipu.edu.reflect.SystemService");
        Object obj = clazz.newInstance();
        Method logoutMethod = clazz.getDeclaredMethod("logout");
        logoutMethod.invoke(obj);
    }
}

