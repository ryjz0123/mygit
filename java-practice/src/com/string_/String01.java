package com.string_;

public class String01 {
    public static void main(String[] args) {
        String s = new String("");
        for (int i = 0; i < 10; i++) {
            s += "hello";
        }
        System.out.println(s);
        String s1 = "孙悟空";
        s1 = s1.concat("猪八戒");  // 拼接字符串
        System.out.println(s1);
        String s2 = "abcacda";
        System.out.println(s2.replace("a","e"));  //替换
        String poem = "锄禾日当午,汗滴禾下土,谁知盘中餐,粒粒皆辛苦";
        String[] split = poem.split(",");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
        String a = "jak";
        String b = "jack";
        b=b.toUpperCase();
        System.out.println(a.compareTo(b));
        System.out.println(b);
        System.out.println(b.charAt(2));
    }
}
