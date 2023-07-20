package com.date_;

import java.util.Calendar;

public class Date02 {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();  //通过getInstance()来获取实例，不能new
        System.out.println(c);
        //获取日历对象的某个日历字段
        System.out.println("年：" + c.get(Calendar.YEAR));
        System.out.println("月：" + (c.get(Calendar.MONTH)+1));
        System.out.println("日：" + c.get(Calendar.DAY_OF_MONTH));
        //Calendar没有专门格式化方法，需要自己组合
    }
}
