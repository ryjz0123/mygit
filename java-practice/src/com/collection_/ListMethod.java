package com.collection_;

import java.util.ArrayList;
import java.util.List;

public class ListMethod {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("张三丰");
        list.add("贾宝玉");

        list.add(1,"林黛玉");
        List list1 = new ArrayList();
        list1.add("jack");
        list1.add("tom");
        list.addAll(1,list1);
        System.out.println(list.indexOf("tom"));
        System.out.println(list.remove(1));
        list.set(0,"jerry");

        System.out.println("list=" + list);
        System.out.println(list.subList(0, 3));
    }
}
