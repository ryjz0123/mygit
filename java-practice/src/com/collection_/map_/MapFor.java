package com.collection_.map_;

import java.util.*;

public class MapFor {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("no1","jack");
        map.put("no2","john");
        map.put("no4","siri");
        map.put("no3","lucy");
        map.put("no4","jerry");
        map.put(1,1);

        //第一组：先取出所有的 key ，通过 key 取出对应的 value
        Set keySet = map.keySet();
        //(1)增强for
        for (Object key : keySet) {
            System.out.println(key + "-" + map.get(key));
        }
        //(2)迭代器
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object key =  iterator.next();
            System.out.println(key + "-" + map.get(key));
        }

        //第二组：把所有的values取出
        Collection values = map.values();
        //(1)增强for
        for (Object value : values) {
            System.out.println(value);
        }
        //(2)迭代器
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            Object value =  iterator1.next();
            System.out.println(value);
        }

        //第三组：通过 EntrySet 来获取 k-v
        Set entrySet = map.entrySet();  //EntrySet<Map.Entry<k,v>>
        //增强for
        for (Object entry : entrySet) {
            //将entry 转成 Map.Entry
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }
        //迭代器
        Iterator iterator2 = entrySet.iterator();
        while (iterator2.hasNext()) {
            Object next =  iterator2.next();
            System.out.println(next.getClass()); // HashMap$Node 实现-> Map.Entry(getKey,getValue)
            //向下转型 Map.Entry
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }


    }
}
