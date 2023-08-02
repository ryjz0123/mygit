package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2023/8/2 14:04
 * @注释
 */
public class RegTheory {
    public static void main(String[] args) {
        String content = "1234Java 语言是多线程的：" +
                "在 Java 语言中，线程是一种特殊的对象，它必须由 Thread 类或" +
                "其子（孙）类来创建。通常9889有两种方法来创建线程：其一，使用型构为 " +
                "Thread(Runnable) 的构造子类将890一个实现了 Runnable 接口的对" +
                "象包装成一个线程，其二，从 Thread 类派生出子类并重写 run 方法，" +
                "使用该子类创建的对象即为1243线程。值得注意的是 Thread 类已经实现了 " +
                "Runnable 接口，因此，任何一个线程均有它的 run 方法，而 run 方法" +
                "中包含了线程所要运行2332的代码。线程的活动由一组方法来控制。Java 语言" +
                "支持多个线程的同时执行，并提供多线程之间的同步机制（关键字为 synchronized）。" ;

        //匹配所有四个数字
        String regStr = "(\\d\\d)(\\d\\d)";  //   \\d 表示任意一个数字
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        /*
            matcher.find()分析:
            1.根据指定的规则，定位满足规则的子字符串
            2.找到后，将子字符串的开始索引记录到mather对象的属性int[] groups,groups[0]=0,
              把该字符串的结束索引+1的值记录到groups[1]=4
              groups[i * 2]记录第i组开始索引位置, groups[i * 2 + 1]记录第i组结束索引位置
            3.同时记录oldLast 的值为 子字符串的结束索引+1 即为4，下次执行find时，就从4开始匹配

            分组：一个()表示一组

            matcher.group(0)分析：
            源码：
                public String group(int group) {
                    if (first < 0)
                        throw new IllegalStateException("No match found");
                    if (group < 0 || group > groupCount())
                        throw new IndexOutOfBoundsException("No group " + group);
                    if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
                        return null;
                    return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
                }
            1.根据 groups[0]=0 和 groups[1]=4 记录的位置，从content开始截取子字符串返回 [0,4)
         */
        while (matcher.find()){
            System.out.println("找到：" + matcher.group(0));
            System.out.println("第1组：" + matcher.group(1));
            System.out.println("第2组：" + matcher.group(2));
        }
    }
}
