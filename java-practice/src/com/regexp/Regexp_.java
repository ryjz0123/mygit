package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2023/8/2 11:02
 * @注释
 */
public class Regexp_ {
    public static void main(String[] args) {

        String content = "Java 语言是多线程的：\n" +
                "在 Java 语言中，线程是一种特殊的对象，它必须由 Thread 类或" +
                "其子（孙）类来创建。通常有两种方法来创建线程：其一，使用型构为 " +
                "Thread(Runnable) 的构造子类将一个实现了 Runnable 接口的对" +
                "象包装成一个线程，其二，从 Thread 类派生出子类并重写 run 方法，" +
                "使用该子类创建的对象即为线程。值得注意的是 Thread 类已经实现了 " +
                "Runnable 接口，因此，任何一个线程均有它的 run 方法，而 run 方法" +
                "中包含了线程所要运行的代码。线程的活动由一组方法来控制。Java 语言" +
                "支持多个线程的同时执行，并提供多线程之间的同步机制（关键字为 synchronized）。\n" ;

        //创建Pattern对象
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        //创建一个匹配器对象
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()){
            System.out.println("找到：" + matcher.group(0));
        }
    }
}
