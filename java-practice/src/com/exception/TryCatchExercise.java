package com.exception;

import java.util.Scanner;

public class TryCatchExercise {
    public static void main(String[] args) {
        //如果用户输入的不是整数，提示用户反复输入，知道输入一个整数为止
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        String inputStr;
        while (true) {
            System.out.println("请输入一个整数：");
            inputStr = scanner.next();
            try {
                num = Integer.parseInt(inputStr);
                break;
            } catch (NumberFormatException e) {
                System.out.println("你输入的不是整数");
            }
        }
        System.out.println(num);
    }
}
