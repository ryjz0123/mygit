package com.codeBlock;

public class CodeBlock02 {
    public static void main(String[] args) {
        A a = new A();
    }
}
class A {
    public A() {
        System.out.println("A 构造器");
    }
    private int n2 = getN2();

    public int getN2() {
        System.out.println("getN2()...");
        return 200;
    }
    {
        System.out.println("A 普通代码块");
    }
    private static int n1 = getN1();
    static {
        System.out.println("A 静态代码块");
    }

    public static int getN1() {
        System.out.println("getN1()...");
        return 100;
    }
}