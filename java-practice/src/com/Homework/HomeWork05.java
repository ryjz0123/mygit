package com.Homework;

public class HomeWork05 {
    public static void main(String[] args) {

    }
}
class Ac {
    private String name = "bbb";
    public void f1() {
        class B { //局部内部类
            private final String name = "aaa";
            void show() {
                System.out.println(name + "\t" + Ac.this.name);
            }
        }
        new B().show();
    }

    public static void main(String[] args) {
        new Ac().f1();
    }
}
