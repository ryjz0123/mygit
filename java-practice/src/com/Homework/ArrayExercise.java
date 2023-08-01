package com.Homework;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayExercise {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦",100);
        books[1] = new Book("金瓶梅新",90);
        books[2] = new Book("青年文摘20年",5);
        books[3] = new Book("java从入门到放弃",300);
        sortByPrice(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (Integer) o1;
                int i2 = (Integer) o2;
                return i1 - i2;
            }
        });
        System.out.println(Arrays.toString(books));
        sortByLength(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int price1 = (Integer) o1;
                int price2 = (Integer) o2;
                if ((price1 - price2) > 0){
                    return 1;
                }else if ((price1 - price2) < 0){
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        System.out.println(Arrays.toString(books));
    }
    public static void sortByPrice(Book[] books, Comparator c) {
        for (int i = 0; i < books.length - 1; i++) { //排序次数
            Book temp ;
            for (int j = 0; j < books.length - i - 1; j++) {

                if (c.compare(books[j].getPrice(),books[j+1].getPrice()) > 0 ){
                    temp = books[j];
                    books[j] = books[j+1];
                    books[j+1] = temp;
                }
            }
        }
    }
    public static void sortByLength(Book[] books, Comparator c) {
        for (int i = 0; i < books.length - 1; i++) { //排序次数
            Book temp ;
            for (int j = 0; j < books.length - i - 1; j++) {

                if (c.compare(books[j].getName().length(),books[j+1].getName().length()) > 0 ){
                    temp = books[j];
                    books[j] = books[j+1];
                    books[j+1] = temp;
                }
            }
        }
    }
}

class Book {
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}