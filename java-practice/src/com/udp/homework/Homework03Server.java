package com.udp.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Homework03Server {
    public static void main(String[] args) throws Exception {
        //在9999端口监听
        ServerSocket serverSocket = new ServerSocket(9999);
        //等待客户端连接
        System.out.println("服务端等待连接-----");
        Socket socket = serverSocket.accept();
        //读取客户端发送要下载的文件
        InputStream inputStream = socket.getInputStream();
        byte[] b = new byte[1024];
        int len = 0;
        String downLoadFileName = "";
        while ((len = inputStream.read(b)) != -1){
            downLoadFileName += new String(b,0,len);
        }
        System.out.println("文件名=" + downLoadFileName);

        String resFileName = "";
        if ("改图鸭(1)".equals(downLoadFileName)){
            resFileName = "src\\改图鸭 (1).png";
        }else {
            resFileName = "src\\改图鸭 (2).png";
        }

        //创建输入流读取文件
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(resFileName));
        //使用工具类StreamUtils，读取文件到一个字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        //写入到数据通道，返回给客户端
        bufferedOutputStream.write(bytes);
        socket.shutdownOutput();

        bufferedInputStream.close();
        bufferedOutputStream.close();
        socket.close();
        inputStream.close();

        System.out.println("服务端退出----");

    }
}
