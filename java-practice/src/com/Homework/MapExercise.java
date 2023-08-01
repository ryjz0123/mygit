package com.Homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExercise {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        Employee jack = new Employee("jack", 20000, 01);
        Employee jerry = new Employee("jerry", 10000, 02);
        Employee tom = new Employee("tom", 25000, 03);
        Employee lili = new Employee("lili", 12000, 04);
        map.put(jack.getId(),jack);
        map.put(jerry.getId(),jerry);
        map.put(tom.getId(),tom);
        map.put(lili.getId(),lili);

        System.out.println("=======方式一=======");
        Set set = map.keySet();
        for (Object key : set) {
            Employee employee = (Employee) map.get(key);
            if (employee.getSalary() > 18000){
                System.out.println(employee);
            }
        }

        System.out.println("=======方式二=======");
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            Map.Entry entry = (Map.Entry) next;
            Employee employee = (Employee) entry.getValue();
            if (employee.getSalary() > 18000){
                System.out.println(employee);
            }
        }
    }
}
class Employee{
    private String name;
    private double salary;
    private int id;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee(String name, double salary, int id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }
}