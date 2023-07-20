package com.wrapper;

public class Wrapper_To_String {
    public static void main(String[] args) {
        //包装类（Integer）转换为 String
        Integer i = 100;  //自动装箱

        //方式一
        String str1 = i + "";
        //方式二
        String str2 = i.toString();
        //方式三
        String str3 = String.valueOf(i);

        //String 转换为 包装类（Integer）
        String str4 = "1234";
        Integer i2 = Integer.parseInt(str4);  //使用自动装箱
        Integer i3 = new Integer(str4);  //构造器
    }
}
