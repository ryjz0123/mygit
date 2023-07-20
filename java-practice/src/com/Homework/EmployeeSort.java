package com.Homework;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class EmployeeSort {
    public static void main(String[] args) {

        ArrayList<Employee1> employee1s = new ArrayList<>();
        employee1s.add(new Employee1("tom",10000,new MyDate(2000,10,13)));
        employee1s.add(new Employee1("lee",10000,new MyDate(2002,10,13)));
        employee1s.add(new Employee1("lucy",12000,new MyDate(2001,9,13)));
        employee1s.add(new Employee1("john",11000,new MyDate(2002,1,1)));
        employee1s.sort(new Comparator<Employee1>(){
            @Override
            public int compare(Employee1 o1, Employee1 o2) {
                if (o1.getName().length() != o2.getName().length()){
                    return o1.getName().length() - o2.getName().length();
                }else {
                    return o1.getBirthday().compareTo(o2.getBirthday());
                }
            }
        });
        Iterator<Employee1> iterator = employee1s.iterator();
        while (iterator.hasNext()) {
            Employee1 next = iterator.next();
            System.out.println(next);
        }
    }
}
class Employee1{
    private String name;
    private double sal;
    private MyDate birthday;

    @Override
    public String toString() {
        return "Employee1{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public Employee1(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }
}
class MyDate implements Comparable{
    private int year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public int getBirth(){
        return year*1000 + month*10 + day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        MyDate e = (MyDate) o;
        return this.getBirth() - e.getBirth();
    }
}