package com.udp.homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Homework03Client {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入下载的文件名：");
        String downloadFileName = scanner.next();

        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(downloadFileName.getBytes());
        //设置写入结束标志
        socket.shutdownOutput();

        //读取服务端返回的文件
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);

        //得到一个输出流，准备将bytes写入到磁盘文件
        String filePath = "e:\\" + downloadFileName + ".png";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath));
        bufferedOutputStream.write(bytes);

        bufferedOutputStream.close();
        bufferedInputStream.close();
        outputStream.close();
        socket.close();

        System.out.println("客户端退出----");
    }
}
