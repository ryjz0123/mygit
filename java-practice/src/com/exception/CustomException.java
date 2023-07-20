package com.exception;

public class CustomException {
    public static void main(String[] args) throws AgeException{
        int age = 18;
        if (!(age >= 18 && age <=120)){
            throw new AgeException("年龄需要在18-120之间");
        }
        System.out.println("你的年龄范围正确");
    }
}
class AgeException extends RuntimeException {
    public AgeException(String message) {
        super(message);
    }
}