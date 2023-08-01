package com.file;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStream_ {
    public static void main(String[] args) {

    }

    @Test
    public void readFile01() throws IOException {
        String filePath = "e:\\hello.txt";
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            int read = 0;
            //从文件中读取一个字节数据
            while ((read = fileInputStream.read()) != -1){
                System.out.println((char) read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            fileInputStream.close();
        }
    }

    @Test
    public void readFile02() throws IOException {
        String filePath = "e:\\hello.txt";
        FileInputStream fileInputStream = null;
        byte[] buf = new byte[8];
        int readLen = 0;
        try {
            fileInputStream = new FileInputStream(filePath);
            //如果读取正常，返回实际读取的字节数，如果返回-1，表示读取到末尾
            while ((readLen=fileInputStream.read(buf)) != -1){
                System.out.println(new String(buf,0,readLen));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            fileInputStream.close();
        }
    }
}
