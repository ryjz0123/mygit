package com.collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Collection_ {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("jack");
        list.add(100);
        list.add(true);
        System.out.println("list=" + list);
        list.remove(2);
        list.remove((Integer)100);
        System.out.println("list=" + list);
        System.out.println(list.contains("jack"));
        System.out.println(list.size());
        System.out.println("list=" + list);
        list.clear();
        System.out.println(list.isEmpty());
        ArrayList list1 = new ArrayList();
        list1.add("红楼梦");
        list1.add("三国演义");
        list.addAll(list1);
        System.out.printf("list1="+list1);
        System.out.println("list=" + list);
        System.out.println(list.contains(list1));
        System.out.println(list.removeAll(list1));
    }
}
