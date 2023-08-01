package com.codeBlock;

public class CodeBlock01 {
    public static void main(String[] args) {
        DD dd = new DD();
        DD dd1 = new DD();
    }
}
class DD {
    static {
        System.out.println("DD 的静态代码块被执行...");
    }
    {
        System.out.println("DD 的普通代码块被执行...");
    }
}