package com.Homework;

import java.util.Scanner;

public class Register {
    public static void main(String[] args) {
        String username;
        String password;
        String email;
        Scanner scanner = new Scanner(System.in);

            System.out.println("请输入用户名：");
            username = scanner.next();
            System.out.println("请输入密码：");
            password = scanner.next();
            System.out.println("请输入邮箱：");
            email = scanner.next();
        try {
            isTrue(username,password,email);
            System.out.println("注册成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void isTrue(String username,String password,String email){
        if(!(username != null && password != null && email!=null))
        if (!(username.length() >= 2 && username.length() <= 4)) {
            throw new RuntimeException("用户名长度不正确");
        }

        if(!(password.length()==6 && isDigital(password))){
            throw new RuntimeException("密码长度要求为6，且全是数字");
        }

        int i = email.indexOf('@');
        int j = email.indexOf('.');
        if(!(i > 0 && j > i)){
            throw new RuntimeException("邮箱格式不正确");
        }

    }
    public static boolean isDigital(String str){
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] < '0' || chars[i] > '9'){
                return false;
            }
        }
        return true;
    }
}
//class RegisterException extends RuntimeException {
//    public RegisterException(String message){
//        super(message);
//    }
//}
