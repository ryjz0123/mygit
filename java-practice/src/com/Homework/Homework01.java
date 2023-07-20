package com.Homework;

public class Homework01 {
    public static void main(String[] args) {
        /*
        * 编写应用程序EcmDef.java，接收命令行的两个参数（整数），计算两数相除
        * 要求使用方法 cal（int n1,int n2)
        * 对数据格式不正确（NumberFormatException)、缺少命令行参数（ArrayIndexOutOfBoundsException）、除0进行异常处理（ArithmeticException）
        * */
        try {
            //验证参数个数
            if (args.length != 2){
                throw new ArrayIndexOutOfBoundsException("参数个数错误");
            }

            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);
            //Boolean f = true;

            double res = cal(n1,n2);
            System.out.println("计算结果为：" + res);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }catch (NumberFormatException e){
            System.out.println("参数格式不正确，需要输入整数");
        }catch (ArithmeticException e){
            System.out.println("出现除0错误");
        }

    }
    public static double cal(int n1,int n2) {
        return n1 / n2;
    }
}
