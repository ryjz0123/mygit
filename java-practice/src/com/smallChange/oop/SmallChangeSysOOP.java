package com.smallChange.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
* 该类是完成零钱通的各个功能的类
* 使用OOP（面向对象编程）
* */
public class SmallChangeSysOOP {
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    String key = "";
    String details = "==========零钱通明细==========";
    double money = 0;
    double balance = 0;  //余额
    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //格式化日期

    String note = "";  // 支出去向

    //显示菜单
    public void mainMenu() {
        do {
            System.out.println("\n==========零钱通菜单==========");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 支出");
            System.out.println("\t\t\t4 退    出");

            System.out.print("请选择（1-4）:");
            key = scanner.next();

            switch (key) {
                case "1" :
                    this.detail();
                    break;
                case "2" :
                    this.income();
                    break;
                case "3" :
                    this.pay();
                    break;
                case "4" :
                    this.exit();
                    break;
                default :
                    System.out.println("选择有误，请重新选择");
            }
        }while (loop);
        System.out.println("已退出。。。。。。");
    }
    //显示零钱通明细
    public void detail() {
        System.out.println(details);
    }
    //收益入账
    public void income() {
        System.out.println("收益入账金额：");
        money = scanner.nextDouble();
        if(money <= 0) {
            System.out.println("收益金额 需要 大于 0");
            return;
        }
        balance += money;
        date = new Date();
        details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + balance;
    }
    //支出
    public void pay() {
        System.out.println("支出去向：");
        note = scanner.next();
        System.out.println("支出金额：");
        money = scanner.nextDouble();
        if (money > balance) {
            System.out.println("支出 不能 大于 余额");
            return;
        }
        balance -= money;
        date = new Date();
        details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
    }
    //退出
    public void exit() {
        String choice = "";
        while(true){
            System.out.println("是否要退出？y/n");
            choice = scanner.next();
            if("y".equals(choice) || "n".equals(choice)){
                break;
            }
        }
        if(choice.equals("y"))
            loop = false;
    }
}
