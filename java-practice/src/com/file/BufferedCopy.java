package com.file;

import java.io.*;

public class BufferedCopy {
    public static void main(String[] args) throws IOException {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(new FileInputStream("e:\\IO流分类.png"));
            bos = new BufferedOutputStream(new FileOutputStream("e:\\IO.png"));

            byte[] buf = new byte[1024];
            int readLen = 0;

            while ((readLen = bis.read(buf)) != -1){
                bos.write(buf,0,readLen);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bis != null){
                bis.close();
            }
            if(bos != null){
                bos.close();
            }
        }
    }
}
