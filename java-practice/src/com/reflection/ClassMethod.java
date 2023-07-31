package com.reflection;

import java.lang.reflect.Field;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2023/7/29 21:47
 * @注释
 */
public class ClassMethod {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String classAllPath = "com.reflection.Person";
        //获取Person类对应的Class对象
        //<?>表示不确定的Java类型
        Class<?> c = Class.forName(classAllPath);
        System.out.println(c);  //显示哪个类的Class对象  com.reflection.Person
        System.out.println(c.getClass());  //输出c的运行类型  java.lang.Class
        System.out.println(c.getPackage().getName());  //得到包名
        System.out.println(c.getName());  //全类名
        //通过 c 创建对象实例
        Person p = (Person)c.newInstance();
        System.out.println(p);
        //通过反射获取属性
        Field name = c.getField("name");
        System.out.println(name.get(p));  //Tom
        //通过反射给属性赋值
        name.set(p,"jack");
        System.out.println(name.get(p));  //jack

        //得到所有的属性
        Field[] fields = c.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }


    }
}
