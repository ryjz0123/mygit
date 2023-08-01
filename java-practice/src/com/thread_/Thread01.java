package com.thread_;

public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat();
        cat.start();  //子线程

        System.out.println("主线程执行" + Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程"+i);
            Thread.sleep(1000);
        }
    }
}
class Cat extends Thread {
    public int times = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("cat----" + (times++) + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (times == 8){
                break;
            }
        }

    }
}