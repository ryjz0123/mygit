package com.collection_.map_;

import java.util.HashMap;
import java.util.Map;

public class Map_ {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("no1","jack");
        map.put("no2","john");
        map.put("no1","siri");  //key相同时，会替换已有的
        map.put("no3","lucy");
        map.put(1,1);
        System.out.println("map="+map);
        map.remove(1);
        Object val = map.get("no1");
        System.out.println("val="+val);
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        map.clear();
        System.out.println(map.containsKey("no2"));
    }
}
