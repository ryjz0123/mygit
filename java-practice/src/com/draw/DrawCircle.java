package com.draw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DrawCircle extends JFrame{ //JFrame对应窗口

    //定义一个面板
    private MyPanel myPanel = null;
    public static void main(String[] args) {
        new DrawCircle();
    }
    public DrawCircle() {
        //初始化面板
        myPanel = new MyPanel();
        //把面板放入到窗口
        this.add(myPanel);
        //设置窗口大小
        this.setSize(400,300);
        //窗口关闭，程序退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置可视
        this.setVisible(true);
        //this.addKeyListener();
    }

}
class MyPanel extends JPanel implements KeyListener {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //g.drawOval(10,10,100,100); //画圆

        g.fillOval(10,10,20,20);



//        g.drawLine(10,10,100,100); //画直线
//        g.drawRect(10,10,100,100); //画矩形边框
//        //设置画笔颜色
//        g.setColor(Color.BLUE);
//        g.fillRect(10,10,100,100); //填充矩形
//
//        //获取图片资源
//        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/1001.jpg"));
//        g.drawImage(image,10,10,500,300,this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
