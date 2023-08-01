package com.Arrays_;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class ArraysMethod01 {
    public static void main(String[] args)  {
        Integer[] integers = {1,20,90};
        System.out.println(Arrays.toString(integers));

        Integer arr[] = {1,-2,7,0,90};
        Arrays.sort(arr);//默认排序方法
        System.out.println(Arrays.toString(arr));
        //定制排序
        //调用定制排序时，传入两个参数 (1)待排序数组 (2)实现了Comparator接口的匿名内部类，它实现compare方法
        //
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {};
        Arrays.fill(arr1,12);
        System.out.println(Arrays.toString(arr1));

        BigInteger bigInteger = new BigInteger("9028386729990002000000000");
        BigInteger bigInteger1 = new BigInteger("999");
        bigInteger1.add(bigInteger); //加
        bigInteger1.subtract(bigInteger); //减
        bigInteger1.multiply(bigInteger);  //乘
        bigInteger1.divide(bigInteger);  //除

        BigDecimal bigDecimal = new BigDecimal("1.999999999999999999999999999999999");
        BigDecimal bigDecimal1 = new BigDecimal("0.000001");
        bigDecimal1.add(bigDecimal);  //加
        bigDecimal1.subtract(bigDecimal);  //减
        bigDecimal1.multiply(bigDecimal);  //乘
        //bigDecimal1.divide(bigDecimal);  //可能抛出异常（除不尽）
        bigDecimal1.divide(bigDecimal,BigDecimal.ROUND_CEILING);  //指定精度


    }
}
