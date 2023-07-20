package com.Homework;

public class Homework {
    public static void main(String[] args) {
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());
        Frock frock1 = new Frock();
        Frock frock2 = new Frock();
        Frock frock3 = new Frock();
        System.out.println(frock1.serialNumber);
        System.out.println(frock2.serialNumber);
        System.out.println(frock3.serialNumber);
    }
}
class Frock {
    private static int currentNum = 100000;
    public int serialNumber;

    public Frock() {
        this.serialNumber = getNextNum();
    }

    public static int getNextNum() {
        currentNum += 100;
        return currentNum;
    }
}
