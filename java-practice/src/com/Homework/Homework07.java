package com.Homework;

public class Homework07 {
    public static void main(String[] args) {
        Car car1 = new Car(12);
        Car car2 = new Car(45);
        Car car3 = new Car(-1);
        car1.new Air().flow();
        car2.new Air().flow();
        car3.new Air().flow();
    }
}

class Car {
    private double temperature;

    public Car(int temperature) {
        this.temperature = temperature;
    }
    class Air{
        public void flow(){
            if (temperature > 40){
                System.out.println("制冷");
            } else if (temperature <=40 && temperature >=0) {
                System.out.println("关闭");
            }else {
                System.out.println("制热");
            }
        }
    }
}