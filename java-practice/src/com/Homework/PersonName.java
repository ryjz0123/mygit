package com.Homework;

public class PersonName {
    public static void main(String[] args) {
        String name = "Willian Jefferson Clinton";
        if (name == null)
            System.out.println("name不能为空");
        String[] names = name.split(" ");
        if (names.length != 3)
            System.out.println("字符串格式不正确");

        String format = String.format("%s,%s .%c", names[2], names[0], names[1].toUpperCase().charAt(0));
        System.out.println(format);
    }
}
