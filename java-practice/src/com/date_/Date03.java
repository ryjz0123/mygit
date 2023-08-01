package com.date_;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Date03 {
    public static void main(String[] args) {
        //使用now()返回表示当前日期时间的对象
        LocalDateTime ldt = LocalDateTime.now();
        //LocalDate ldt1 = LocalDate.now();
        //LocalTime ldt2 = LocalTime.now();
        System.out.println(ldt);
        System.out.println(ldt.getYear());
        System.out.println(ldt.getMonth());
        System.out.println(ldt.getMonthValue());
        System.out.println(ldt.getSecond());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH小时mm分钟ss秒");
        String format = dtf.format(ldt);
        System.out.println(format);

        //通过now()方法获取表示当前当前时间戳的对象
        Instant now = Instant.now();
        System.out.println(now);
        //通过from()方法把 Instant 转成 Date
        Date date = Date.from(now);
        //通过 date 的toInstant()可以把 date 转成 Instant 对象
        Instant instant = date.toInstant();

    }
}
