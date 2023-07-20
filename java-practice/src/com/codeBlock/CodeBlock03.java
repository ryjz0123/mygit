package com.codeBlock;

public class CodeBlock03 {
    public static void main(String[] args) {
        BB bb = new BB();
    }
}
class AA{
    public AA() {
        System.out.println("AA 构造器");
    }
    private int n2 = getN2();

    public int getN2() {
        System.out.println("getN2()AA普通属性");
        return 200;
    }
    {
        System.out.println("AA 普通代码块");
    }
    private static int n1 = getN1();
    static {
        System.out.println("AA 静态代码块");
    }

    public static int getN1() {
        System.out.println("getN1()AA静态属性");
        return 100;
    }
}
class BB extends AA {
    public BB() {
        System.out.println("BB 构造器");
    }
    private int n3 = getN3();

    public int getN3() {
        System.out.println("getN3()BB普通属性");
        return 200;
    }
    {
        System.out.println("BB 普通代码块");
    }
    private static int n4 = getN4();
    static {
        System.out.println("BB 静态代码块");
    }

    public static int getN4() {
        System.out.println("getN4()BB静态属性");
        return 100;
    }
}