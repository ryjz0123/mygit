package com.Tank.tankgame4;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable{

    public EnemyTank(int x, int y) {
        super(x, y);
    }
    //使用Vector保存多个Shot
    //Vector<Shot> shots = new Vector<>();

    @Override
    public void run() {
        while (true){

            if (isLive && shots.size() < 10){
                addshot();
            }

            for (int i = 0; i < 30; i++) {

                //根据tank方向继续移动
                switch (getDirect()) {
                    case 0: //上
                        moveUp();
                        break;
                    case 1:  //右
                        moveRight();
                        break;
                    case 2:  //下
                        moveDown();
                        break;
                    case 3:  //左
                        moveLeft();
                        break;
                }

                //休眠50毫秒
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //随机的改变tank方向
            setDirect((int) (Math.random() * 4));

            if (!isLive){
                break;
            }

        }
    }
}
