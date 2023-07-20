package com.date_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Date01 {
    public static void main(String[] args) throws ParseException {
        Date date = new Date(); //获取系统当前时间
        Date date1 = new Date(923749);  //通过指定毫秒数得到时间

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E");
        String format = sdf.format(date);
        System.out.println(format);

        String s = "2023年7月10日 04:08:23 星期一";
        Date parse = sdf.parse(s);
        System.out.println(sdf.format(parse));


    }
}
