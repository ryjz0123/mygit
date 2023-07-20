package com.houserent.view;

import com.houserent.domain.House;
import com.houserent.service.HouseService;
import com.houserent.utils.Utility;

/*
* 1.显示界面
* 2.接受用户输入
* 3.调用HouseService完成度房屋信息的各种操作
* */
public class HouseView {

    private boolean loop = true;  //控制显示菜单
    private char key = ' ';  //接收用户选择
    private HouseService houseService = new HouseService(2);

    //编写addHouse()接收输入，创建House对象，调用add方法
    public void addHouse() {
        System.out.println("=========================添加房屋=======================");
        System.out.print("姓名：");
        String name = Utility.readString(8);
        System.out.print("电话：");
        String phone = Utility.readString(12);
        System.out.print("地址：");
        String address = Utility.readString(16);
        System.out.print("月租：");
        int rent = Utility.readInt();
        System.out.print("状态：");
        String state = Utility.readString(3);
        House newHouse = new House(0, name, phone, address, rent, state);
        if(houseService.add(newHouse)){
            System.out.println("=========================添加成功=======================");
        }else {
            System.out.println("=========================添加失败=======================");
        }
    }

    //编写delHouse()接收输入的id，调用Service的del方法
    public void delHouse() {
        System.out.println("=========================删除房屋=======================");
        System.out.println("请输入待删除房屋的编号（-1退出）:");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("=========================放弃删除房屋=======================");
            return;
        }
        //System.out.println("请确认是否删除(Y/N)？");
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            if(houseService.del(delId))
                System.out.println("=========================删除成功=======================");
            else
                System.out.println("=========================删除失败=======================");
        }else {
            System.out.println("=========================放弃删除房屋=======================");
        }
    }

    //查找房屋
    public void findHouse() {
        System.out.println("=========================查找房屋=======================");
        System.out.print("请输入要查找的id:");
        int findId = Utility.readInt();
        if (houseService.findById(findId) != null) {
            System.out.println(houseService.findById(findId));
        }else {
            System.out.println("=========================查找房屋id不存在=======================");
        }
    }

    public void updateHouse(){
        System.out.println("=========================修改房屋=======================");
        System.out.println("请选择待修改房屋编号（-1表示退出）");
        int updateId = Utility.readInt();
        if(updateId == -1){
            System.out.println("=======放弃修改房屋信息=======");
            return;
        }
        House house = houseService.findById(updateId);
        if(house == null){
            System.out.println("========不存在该房屋编号========");
            return;
        }

    }
    //编写listHouse()显示房屋列表
    public void listHouse() {
        System.out.println("=========================房屋列表=======================");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if(houses[i] == null)
                break;
            System.out.println(houses[i]);
        }
        System.out.println("=========================房屋列表=======================");

    }
    //退出功能
    public void exit() {
        char c = Utility.readConfirmSelection();
        if(c == 'Y')
            loop = false;
    }
    //    显示主菜单
    public void mainMenu() {
        do{
            System.out.println("=========================房屋出租系统菜单=======================");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删 除 房 屋 信 息");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t6 退      出");
            System.out.println("=========================房屋出租系统菜单=======================");
            System.out.println("请输入你的选择（1-6）:");
            key = Utility.readChar();
            switch (key) {
                case '1' :
                    this.addHouse();
                    break;
                case '2' :
                    this.findHouse();
                    break;
                case '3' :
                    this.delHouse();
                    break;
                case '4' :
                    System.out.println("新 增 房 屋 信 息");
                    break;
                case '5' :
                    this.listHouse();
                    break;
                case '6' :
                    exit();
                    break;
                default:
                    System.out.println("输入错误");
            }
        }while (loop);
    }

}
