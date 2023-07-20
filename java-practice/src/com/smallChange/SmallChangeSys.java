package com.smallChange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {
    //选择菜单
    public static void main(String[] args) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";
        String details = "==========零钱通明细==========";
        double money = 0;
        double balance = 0;  //余额
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //格式化日期

        String note = "";  // 支出去向
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
                    System.out.println(details);
                    break;
                case "2" :
                    System.out.println("收益入账金额：");
                    money = scanner.nextDouble();
                    if(money <= 0) {
                        System.out.println("收益金额 需要 大于 0");
                        break;
                    }
                    balance += money;
                    date = new Date();
                    details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "3" :
                    System.out.println("支出去向：");
                    note = scanner.next();
                    System.out.println("支出金额：");
                    money = scanner.nextDouble();
                    if (money > balance) {
                        System.out.println("支出 不能 大于 余额");
                        break;
                    }
                    balance -= money;
                    date = new Date();
                    details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "4" :
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
                    break;
                default :
                    System.out.println("选择有误，请重新选择");
            }
            System.out.println("");

        }while (loop);
        System.out.println("已退出。。。。。。");
    }
}
