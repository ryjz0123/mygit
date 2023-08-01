package com.houserent.service;

import com.houserent.domain.House;

/*
* 定义House[]，保存House对象
* 1.响应HouseView的调用
* 2.完成对房屋信息的各种操作
* */
public class HouseService {
    private House[] houses;  //保存House对象
    private int houseNums = 1;  //记录当前有多少个房屋信息
    private int idCounter = 1;
    //构造器
    public HouseService(int size) {
        houses = new House[size];  //当创建HouseService对象，指定数组大小
        houses[0] = new House(0,"jack","111299","海淀区",2000,"未出租");
    }

    //list方法，返回houses
    public House[] list() {
        return houses;
    }
    //add方法，添加新对象，返回boolean
    public boolean add(House newHouse){
        //判断是否还可以继续添加
        if (houseNums == houses.length) {
            System.out.println("数组已满，不能再继续添加了...");
            return false;
        }
        houses[houseNums++] = newHouse;
        newHouse .setId(++idCounter);
        return true;
    }

    //add方法，添加新对象，返回boolean
    public boolean del(int delId) {
        int index = -1;
        for (int i = 0; i < houseNums; i++) {
            if (delId == houses[i].getId()){
                index = i;
            }
        }
        if (index == -1)
            return false;
        for (int i = index; i < houseNums - 1; i++) {
            houses[i] = houses[i+1];
        }
        houses[--houseNums] = null;
        return true;
    }

    //查找房屋，返货House对象或者null
    public House findById(int findId) {
        for (int i = 0; i < houseNums; i++) {
            if(findId == houses[i].getId()){
                return houses[i];
            }
        }
        return null;
    }
    public void update(int id) {

    }
}
