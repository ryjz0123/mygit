package com.tankgame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener {
    //定义我的tank
    Hero hero = null;

    //定义敌人 tank
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;
    public MyPanel() {
        hero = new Hero(100,100); //初始化坦克
        hero.setSpeed(3);
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
            enemyTank.setDirect(2);
            enemyTanks.add(enemyTank);
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);  //填充矩形，默认黑色
        drawTank(hero.getX(),hero.getY(),g,hero.getDirect(),0);
//        drawTank(hero.getX()+60,hero.getY(),g,0,1);
//        drawTank(hero.getX()+100,hero.getY()+60,g,1,1);
//        drawTank(hero.getX()+200,hero.getY()+60,g,2,1);
//        drawTank(hero.getX()+300,hero.getY()+60,g,3,1);

        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(),enemyTank.getY(),g,enemyTank.getDirect(),1);
        }
    }

    /**
     * @param x 坦克的左上角x坐标
     * @param y 坦克的左上角y坐标
     * @param g 画笔
     * @param direct 坦克方向（上下左右）
     * @param type 坦克类型
     */
    //画出坦克
    public void drawTank(int x,int y,Graphics g,int direct,int type){
        switch (type) {
            case 0:  //自己的坦克
                g.setColor(Color.cyan);
                break;
            case 1:  //敌人的坦克
                g.setColor(Color.yellow);
                break;
        }

        //根据坦克方向绘制坦克
        //direct表示方向(0：向上  1：向右 2：向下  3：向左)
        switch (direct) {
            case 0: //表示向上
                g.fill3DRect(x,y,10,60,false);  //左边轮子
                g.fill3DRect(x+10,y+10,20,40,false);  //中间
                g.fillOval(x+10,y+20,20,20);  //中间圆圈
                g.drawLine(x+20,y+30,x+20,y);  //炮
                g.fill3DRect(x+30,y,10,60,false);  //右边轮子
                break;
            case 1: //表示向右
                g.fill3DRect(x,y,60,10,false);  //上边轮子
                g.fill3DRect(x+10,y+10,40,20,false);  //中间
                g.fillOval(x+20,y+10,20,20);  //中间圆圈
                g.drawLine(x+30,y+20,x+60,y+20);  //炮
                g.fill3DRect(x,y+30,60,10,false);  //下边轮子
                break;
            case 2: //表示向下
                g.fill3DRect(x,y,10,60,false);  //左边轮子
                g.fill3DRect(x+10,y+10,20,40,false);  //中间
                g.fillOval(x+10,y+20,20,20);  //中间圆圈
                g.drawLine(x+20,y+30,x+20,y+60);  //炮
                g.fill3DRect(x+30,y,10,60,false);  //右边轮子
                break;
            case 3: //表示向左
                g.fill3DRect(x,y,60,10,false);  //上边轮子
                g.fill3DRect(x+10,y+10,40,20,false);  //中间
                g.fillOval(x+20,y+10,20,20);  //中间圆圈
                g.drawLine(x+30,y+20,x,y+20);  //炮
                g.fill3DRect(x,y+30,60,10,false);  //下边轮子
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //处理 wdsa 键按下
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W){  //按下W键
            hero.setDirect(0);
            hero.moveUp();
        }else if (e.getKeyCode() == KeyEvent.VK_D){
            hero.setDirect(1);
            hero.moveRight();
        }else if (e.getKeyCode() == KeyEvent.VK_S){
            hero.setDirect(2);
            hero.moveDown();
        }else if (e.getKeyCode() == KeyEvent.VK_A){
            hero.setDirect(3);
            hero.moveLeft();
        }

        //让面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
