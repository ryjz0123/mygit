package com.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReader_ {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("e:\\a.txt"));
        //读取
        String line;
        //按行读取，读取到文件末尾返回null
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }

        //关闭流，只需要关闭 BufferedReader，因为底层会自动去关闭 节点流 FileReader
        /*
            public void close() throws IOException {
                synchronized (lock) {
                    if (in == null)
                        return;
                    try {
                        in.close();
                    } finally {
                        in = null;
                        cb = null;
                    }
                }
            }
         */
        bufferedReader.close();
    }
}
