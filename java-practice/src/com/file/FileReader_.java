package com.file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_ {
    public static void main(String[] args) throws IOException {

        FileReader fileReader = null;
        int data = 0;

        int readLen = 0;
        char[] buf = new char[8];
        try {
            fileReader = new FileReader("e:\\a.txt");
            //循环读取
//            while ((data = fileReader.read()) != -1){ //读取单个字符
//                System.out.print((char) data);
//            }
//            System.out.println("\n");

            while ((readLen = fileReader.read(buf)) != -1){
                System.out.print(new String(buf,0,readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileReader.close();
        }
    }
}
