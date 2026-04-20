package org.cqipu.edu.reflect;

import java.lang.reflect.Method;
public class ReflectTest02 {
    public static void main(String[] args) throws Exception{
        Class clazz = Class.forName("org.cqipu.edu.reflect.SystemService");
        Object obj = clazz.newInstance();
        Method loginMethod = clazz.getDeclaredMethod("login", String.class, String.class);
        Object retValue = loginMethod.invoke(obj, "admin", "admin123");
        System.out.println(retValue);
    }
}

