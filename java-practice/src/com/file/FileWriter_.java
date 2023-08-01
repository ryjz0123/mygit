package com.file;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_ {
    public static void main(String[] args) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("e:\\note.txt",true);
            //写入单个字符
            fileWriter.write("A");
            //写入字符数组
            char[] chars = {'a','b','c'};
            fileWriter.write(chars);
            //write(char[],off,len)：写入指定数组的指定部分
            fileWriter.write("hello".toCharArray(),0,3);
            //写入字符串
            fileWriter.write("你好");
            //写入字符串指定部分
            fileWriter.write("你好你好你好",1,4);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
