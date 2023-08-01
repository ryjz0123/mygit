package com.Tank.tankgame4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

//为了让Panel不停的重绘子弹，需要将MyPanel 实现 Runnable，当作一个线程使用
public class MyPanel extends JPanel implements KeyListener,Runnable {
    //定义我的tank
    Hero hero = null;

    //定义敌人 tank
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;

    //定义一个Vector，用于存放炸弹
    Vector<Bomb> bombs = new Vector<>();

    //定义三张炸弹图片，用于显示爆炸效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;
    public MyPanel() {
        hero = new Hero(500,100); //初始化坦克
        hero.setSpeed(3);

        //初始化敌人坦克
        for (int i = 0; i < enemyTankSize; i++) {
            //创建敌人坦克
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
            //设置方向
            enemyTank.setDirect(2);
            //启动敌人tank线程
            new Thread(enemyTank).start();

            //加入子弹
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            enemyTank.shots.add(shot);
            //启动shot
            new Thread(shot).start();

            enemyTanks.add(enemyTank);
        }

        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            hitEnemyTank();
            hitHero();
            this.repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //绘制面板
        g.fillRect(0,0,1000,750);  //填充矩形，默认黑色
        if (hero != null && hero.isLive) {
            //绘制自己的tank
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
        }
//        //绘制hero子弹
//        if (hero.shot != null && hero.shot.isLive){
//            g.draw3DRect(hero.shot.x,hero.shot.y,10,10,false);
//        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if (shot != null && shot.isLive){
                g.draw3DRect(shot.x,shot.y,10,10,false);
            }else {
                hero.shots.remove(shot);
            }
        }
        //绘制敌人tank
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            if (enemyTank.isLive) {  //判断当前tank是否存活
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);
                //绘制 enemyTank 所有子弹
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    //取出子弹
                    Shot shot = enemyTank.shots.get(j);
                    if (shot!=null&&shot.isLive) {
                        //绘制敌人tank的子弹
                        g.draw3DRect(shot.x, shot.y, 10, 10, false);
                    } else {
                        //移除子弹
                        enemyTank.shots.remove(shot);
                    }
                }
            }
        }

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //如果bombs集合中有炸弹，就画出
        for (int i = 0; i < bombs.size(); i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //取出炸弹
            Bomb bomb = bombs.get(i);
            //根据当前bomb对象的生命值显示不同图片
            if (bomb.life > 6){
                g.drawImage(image1,bomb.x,bomb.y,60,60,this);
            }else if (bomb.life > 3){
                g.drawImage(image2,bomb.x,bomb.y,60,60,this);
            }else {
                g.drawImage(image3,bomb.x,bomb.y,60,60,this);
            }
            bomb.lifeDown();
            //如果bomb的life为0，就从集合中remove
            if (bomb.life == 0){
                bombs.remove(bomb);
            }
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

    //判断敌人坦克是否击中我方tank
    public void hitHero(){
        //遍历敌人坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                Shot shot = enemyTank.shots.get(j);
                if (hero.isLive && shot.isLive){
                    hitTank(shot,hero);
                }
            }
        }
    }
    public void hitEnemyTank() {

            for (int i = 0; i < hero.shots.size(); i++) {
                Shot shot = hero.shots.get(i);
                //判断是否击中敌人tank
                if (shot != null && shot.isLive) {
                    //遍历敌人所有tank
                    for (int j = 0; j < enemyTanks.size(); i++) {
                        EnemyTank enemyTank = enemyTanks.get(j);
                        hitTank(hero.shot, enemyTank);
                    }
                }
            }

    }
    //判断我方子弹是否击中敌人
    public void hitTank(Shot s, Tank tank){

        //判断s是否击中
        switch (tank.getDirect()){
            case 0: //tank向上
            case 2: //tank向下
                if (s.x > tank.getX() && s.x < tank.getX() + 40
                    && s.y > tank.getY() && s.y < tank.getY() + 60){
                    tank.isLive = false;
                    s.isLive = false;
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                    //移除敌人tank
                    enemyTanks.remove(tank);
                }
                break;
            case 1: //tank向右
            case 3: //tank向左
                if (s.x > tank.getX() && s.x < tank.getX() + 60
                    && s.y > tank.getY() && s.y < tank.getY() + 40){
                    tank.isLive = false;
                    s.isLive = false;
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                }
                break;
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


        //按下J键发射
        if (e.getKeyCode() == KeyEvent.VK_J){
            hero.shotEnemyTank();
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        //让面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
