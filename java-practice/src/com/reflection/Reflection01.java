package com.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2023/7/29 18:28
 * @注释
 */
public class Reflection01 {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        m1();
        m2();
    }
    public static void m1(){
        Person person = new Person();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 9000000; i++) {
            person.work();
        }
        long end = System.currentTimeMillis();
        System.out.println("传统方法耗时=" + (end - start) );
    }

    public static void m2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class c = Class.forName("com.reflection.Person");
        Object o = c.newInstance();
        Method work = c.getMethod("work");

        long start = System.currentTimeMillis();
        for (int i = 0; i < 9000000; i++) {
            work.invoke(o); //反射调用方法
        }
        long end = System.currentTimeMillis();
        System.out.println("反射方法耗时=" + (end - start) );
    }
}
