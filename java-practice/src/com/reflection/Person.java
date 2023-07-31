package com.reflection;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2023/7/29 21:16
 * @注释
 */
public class Person {//私有属性
    public String name = "Tom";//公有属性
    public int age = 18;
    //构造方法
    public Person() {

    }
    //私有方法
    private void say(){
        System.out.println("private say()...");
    }
    //公有方法
    public void work(){
        //System.out.println("public work()...");
    }

}
