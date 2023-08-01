package com.thread_;

public class Money {
    public static void main(String[] args) {
        A a = new A();
        Thread thread1 = new Thread(a);
        Thread thread2 = new Thread(a);
        thread1.setName("thread1");
        thread1.start();
        thread2.setName("thread2");
        thread2.start();
    }
}

class A implements Runnable {

    private int money = 10000;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (money < 1000) {
                    System.out.println("余额不足");
                    break;
                }

                money -= 1000;
                System.out.println(Thread.currentThread().getName() + "取出了1000，当前余额=" + money);

            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
