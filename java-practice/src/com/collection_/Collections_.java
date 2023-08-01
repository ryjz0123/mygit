package com.collection_;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Collections_ {
    public static void main(String[] args) {
        //创建ArrayList集合用于测试
        ArrayList list = new ArrayList();
        list.add("tom");
        list.add("smith");
        list.add("king");
        list.add("milan");
        System.out.println(list);
        //reverse(list)：反转list中元素的顺序
        Collections.reverse(list);
        System.out.println("反转list="+list);
        //shuffle(list)：对list集合元素进行随机排序
        Collections.shuffle(list);
        System.out.println("随机排序list="+list);
        //sort(list)：根据元素的自然顺序对指定list集合元素按升序排序
        Collections.sort(list);
        System.out.println("自然排序list="+list);
        //sort(list,Comparator)：根据指定的 Comparator 产生的顺序对 list 集合元素进行排序
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1,Object o2){
                return ((String)o1).length() - ((String)o2).length();
            }
        });
        System.out.println("按长度排序list="+list);
        //swap(list,i ,j)：将list集合中的第i处元素和第j处元素进行交换
        Collections.swap(list,0,1);
        System.out.println("交换后list="+list);

        System.out.println("自然顺序最大元素=" + Collections.max(list));

        Object max = Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        System.out.println("长度最大的元素=" + max);

        //Object min(Collection)
        //Object min(Collection,Comparator)

        System.out.println("tom出现的次数="+Collections.frequency(list,"tom"));

        //void copy(List dest,List src)：将src中的内容复制到dest中

        ArrayList dest = new ArrayList();
        //为了完成一个完整拷贝，需要先给dest赋值，大小和list.size()一样
        for (int i = 0; i < list.size(); i++) {
            dest.add("");
        }
        Collections.copy(dest,list);
        System.out.println("dest="+dest);
        Collections.replaceAll(list,"tom","汤姆");
        System.out.println("替换后list=" + list);
    }
}
