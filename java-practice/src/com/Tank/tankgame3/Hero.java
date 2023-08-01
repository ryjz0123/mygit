package com.Tank.tankgame3;

public class Hero extends Tank {
    Shot shot = null;
    public Hero(int x,int y){
        super(x,y);
    }
    public void shotEnemyTank(){
        switch (getDirect()) {
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

        new Thread(shot).start();
    }
}
