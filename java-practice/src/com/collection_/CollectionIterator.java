package com.collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionIterator {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        collection.add(new Book("三国演义","罗贯中",29.9));
        collection.add(new Book("小李飞刀","古龙",19.9));
        collection.add(new Book("红楼梦","曹雪芹",29.9));

        //System.out.printf("collection=" + collection);

        Iterator iterator = collection.iterator();
        //快捷键  itit
        while (iterator.hasNext()){ //判断是否还有数据
            //返回下一个元素，类型是Object
            Object next = iterator.next();
            System.out.println(next);
        }
        //退出while循环后，iterator指向最后元素，如果需要再次遍历，需要重置迭代器
        iterator = collection.iterator();
        for (Object book :
                collection) {
            System.out.println(book);
        }

    }
}
class Book {
    private String name;
    private String author;
    private double price;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }
}