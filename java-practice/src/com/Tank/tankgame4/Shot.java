package com.Tank.tankgame4;

public class Shot implements Runnable{

    public int x;
    public int y;
    public int direct = 0;
    public int speed = 3;
    public boolean isLive = true;

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (direct) {
                case 0: //上
                    y -= speed;
                    break;
                case 1:  //右
                    x += speed;
                    break;
                case 2:  //下
                    y += speed;
                    break;
                case 3:  //左
                    x -= speed;
                    break;
                default:
                    System.out.println("");
            }

            System.out.println(x+"  " + y);

            //当子弹移动到面板的边界时，销毁子弹线程
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive)) {
                isLive = false;
                break;
            }
        }
    }
}
