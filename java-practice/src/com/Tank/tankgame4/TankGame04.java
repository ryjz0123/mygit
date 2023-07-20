package com.Tank.tankgame4;

import javax.swing.*;

public class TankGame04 extends JFrame {
    MyPanel myPanel = null;
    public static void main(String[] args) {
        TankGame04 tankGame = new TankGame04();

    }
    public TankGame04(){
        myPanel = new MyPanel();
        this.add(myPanel);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(myPanel);  //设置监听
        this.setVisible(true);

        new Thread(myPanel).start();
    }


}
