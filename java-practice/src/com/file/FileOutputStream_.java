package com.file;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.FileOutputStream;

public class FileOutputStream_ {
    public static void main(String[] args) {

    }

    @Test
    public void writeFile() throws IOException {
        String filePath = "e:\\a.txt";
        FileOutputStream fileOutputStream = null;
        try {
            //写入内容会覆盖原来内容
//            fileOutputStream = new FileOutputStream(filePath);
            //写入内容时，追加到文件末尾
            fileOutputStream = new FileOutputStream(filePath,true);
            //写入一个字节
            fileOutputStream.write('a');
            //写入字符串
            String str = "hello,world";
            //getBytes()，可以把字符串转换成字符数组
            fileOutputStream.write(str.getBytes());
            //write(byte[] b,int off,int len)
            fileOutputStream.write(str.getBytes(),1,6);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            fileOutputStream.close();
        }
    }
}
