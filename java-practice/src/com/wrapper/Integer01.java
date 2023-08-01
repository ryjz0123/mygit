package com.wrapper;

public class Integer01 {
    public static void main(String[] args) {
        //手动装箱(jdk5前)
        int n1 = 100;
        Integer integer = new Integer(n1);
        Integer integer1 = Integer.valueOf(n1);

        //手动拆箱
        int i = integer.intValue();

        int n2 = 100;
        //主动装箱
        Integer integer2 = n2;  //底层使用的是 Integer.valueOf(n2) || new Integer(n2)

        //自动拆箱
        int n3 = integer2;  //底层使用的是 intValue()
    }
}
