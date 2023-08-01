package com.Tank.tankgame4;

import java.util.Vector;

public class Tank {
    private int x;
    private int y;
    private int direct; //tank方向
    private int speed = 1;
    boolean isLive = true;

    Vector<Shot> shots = new Vector<>();
    Shot shot = null;
    public void moveUp(){
        if(y > 0)
            y -= speed;
    }

    public void moveRight(){
        if (x + 60 < 1000)
            x += speed;
    }

    public void moveDown(){
        if (y + 60 < 750)
            y += speed;
    }

    public void moveLeft(){
        if (x > 0)
            x -= speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void addshot() {
        switch(direct){
            case 0:  //向上
                shot = new Shot(getX()+20,getY(),getDirect());
                break;
            case 1: //向右
                shot = new Shot(getX()+60,getY()+20,getDirect());
                break;
            case 2:  //向下
                shot = new Shot(getX()+20,getY()+60,getDirect());
                break;
            case 3:  //向左
                shot = new Shot(getX(),getY()+20,getDirect());
                break;
        }
        shots.add(shot);
        new Thread(shot).start();
    }
}
