package com.collection_;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSet_ {
    public static void main(String[] args) {

        //使用TreeSet提供的一个构造器，可以传入一个比较器（匿名内部类），并指定排序规则
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //调用 compareTo 方法进行字符串比较
                return ((String) o1).compareTo((String) o2);
            }
        });

        treeSet.add("jack");
        treeSet.add("tom");
        treeSet.add("sp");
        treeSet.add("a");
        System.out.println("treeSet" + treeSet);

        /*
        1.构造器把传入的比较器对象，赋给了 TreeSet 的底层的 TreeMap 的属性 this.comparator
            public TreeMap(Comparator<? super K> comparator) {
                this.comparator = comparator;
            }
        2.在调用treeSet.add("tom")，底层会执行到
            if (cpr != null) {  // cpr 就是匿名内部类（对象）
                do {
                    parent = t;
                    cmp = cpr.compare(key, t.key);  //动态绑定到匿名内部类（对象）compare
                    if (cmp < 0)
                        t = t.left;
                    else if (cmp > 0)
                        t = t.right;
                    else
                        return t.setValue(value);
                } while (t != null);
            }
         */
    }
}
