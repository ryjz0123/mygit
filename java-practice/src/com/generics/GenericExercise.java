package com.generics;

import java.util.*;

public class GenericExercise {
    public static void main(String[] args) {
        HashSet<Student> students = new HashSet<Student>();
        Student john = new Student("john", 19);
        Student tom = new Student("tom", 20);
        Student lucy = new Student("lucy",18);
        students.add(john);
        students.add(tom);
        students.add(lucy);
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student next =  iterator.next();
            System.out.println(next);
        }

        HashMap<String,Student> map = new HashMap<String,Student>();
        map.put("john",john);
        map.put("tom",tom);
        map.put("lucy",lucy);
        Set<Map.Entry<String, Student>> entries = map.entrySet();
        for (Map.Entry<String,Student> entry : entries) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

    }
}
class Student {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}