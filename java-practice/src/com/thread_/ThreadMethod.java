package com.thread_;

public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();

        for (int i = 0; i < 20; i++) {
            Thread.sleep(500);
            System.out.println("主线程----" + i);

            if (i == 5){
                //t.join();
                Thread.yield();
            }
        }
    }
}
class T extends Thread {
    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("JoinThread------" + i);
        }
    }
}
