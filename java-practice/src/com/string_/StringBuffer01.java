package com.string_;

import org.omg.CORBA.WCharSeqHelper;

import java.util.Arrays;

public class StringBuffer01 {
    public static void main(String[] args) {
        //创建一个大小为16的char[],用于存放字符内容
        StringBuffer stringBuffer = new StringBuffer();
        //通过构造器指定char[]大小
        StringBuffer stringBuffer1 = new StringBuffer(100);
        //通过给一个String创建StringBuffer，char[]大小为str.length + 16
        StringBuffer stringBuffer2 = new StringBuffer("hello");
        //
        //StringBuffer stringBuffer3 = new StringBuffer(CharSequence seq);

        //String 转换为 StringBuffer
        String str = "hello jack";
        //方式一：使用构造器
        //返回StringBuffer，对str本身没有影响
        StringBuffer stringBuffer3 = new StringBuffer(str);
        //方式二：使用append方法
        StringBuffer stringBuffer5 = new StringBuffer();
        stringBuffer5.append(str);

        //StringBuffer 转成 String
        StringBuffer stringBuffer6 = new StringBuffer("hello");
        //方式一：使用StringBuffer 提供的 toString方法
        String s = stringBuffer6.toString();

        //方式二：通过构造器
        String s2 = new String(stringBuffer6);

    }
}
