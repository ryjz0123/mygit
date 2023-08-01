package com.Homework;

import org.junit.jupiter.api.Test;

import java.util.*;

public class GenericHomework {
    public static void main(String[] args) {
        Dao<Map.Entry> entryDao = new Dao<>();

    }
    @Test
    public void testList() {
        Dao<User> userDao = new Dao<>();
        userDao.save("001",new User(1,10,"jack"));
        userDao.save("002",new User(2,13,"john"));

        List<User> list = userDao.list();

        System.out.println(list);
        System.out.println(userDao.get("001"));
    }
}
class User {
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
class Dao<T> {
    private Map<String,T> map = new HashMap<>();
    public void save(String id,T entity){
        map.put(id,entity);
    }
    public T get(String id){
        return map.get(id);
    }
    public void update(String id,T entity){
        map.put(id, entity);
    }
    public List<T> list(){
        List<T> list = new ArrayList<>();
        Set<String> keySet = map.keySet();
        for (String o : keySet) {
            list.add(map.get(o));
        }

        return list;
    }
    public void delete(String id){
        map.remove(id);
    }
}