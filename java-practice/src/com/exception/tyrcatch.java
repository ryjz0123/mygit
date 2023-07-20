package com.exception;

public class tyrcatch {
    public static void main(String[] args) {
        //ctrl + alt + t
        try {
            String str = "123";
            int a = Integer.parseInt(str);
            System.out.println("数字："+a);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
