package com.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        /*
            1.创建文件输入流，将文件读取到程序
            2.创建文件输出流，将读取到的文件数据，写入到指定文件
          */

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream("e:\\a.txt");
            fileOutputStream = new FileOutputStream("e:\\b.txt");

            byte[] buffer = new byte[8];
            int readLen = 0;
            while ((readLen = fileInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,readLen);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileInputStream.close();
            fileOutputStream.close();
        }
    }
}
