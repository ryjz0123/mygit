package com.Tank.tankgame4;

import java.util.Vector;

public class Hero extends Tank {
    //Shot shot = null;

    public Hero(int x,int y){
        super(x,y);
    }
    public void shotEnemyTank(){
        if (shots.size() == 5){
            return;
        }

        addshot();
    }
}
