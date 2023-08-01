package com.thread_;

import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        T1 t1 = new T1();
        new Thread(t1).start();
        new T2(t1).start();
    }
}
class T1 implements Runnable {

    private boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public boolean isLoop() {
        return loop;
    }

    @Override
    public void run() {
        while (loop){
            int num = (int) (Math.random() * 100);
            System.out.println(num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class T2 extends Thread {
    private T1 t1;
    private Scanner scanner =  new Scanner(System.in);
    public T2(T1 t1) {
        this.t1 = t1;
    }

    @Override
    public void run() {
        System.out.println("输入：");
        char key = scanner.next().toUpperCase().charAt(0);

        if (key == 'Q'){
            t1.setLoop(false);
        }
    }
}