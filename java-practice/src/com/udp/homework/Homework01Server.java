package com.udp.homework;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import java.io.*;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Homework01Server {
    public static void main(String[] args) throws IOException {
        //在本机9999端口监听等待连接
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在9999端口监听，等待连接-----");

        //当没有客户端连接9999端口时，程序会阻塞，等待连接，有客户端连接时，会返回Socket对象，程序继续
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        String answer = "";
        if ("name".equals(s)){
            answer = "我是Jack";
        } else if ("hobby".equals(s)) {
            answer = "编写Java程序";
        }else {
            answer = "？？？";
        }

        OutputStream outputStream  = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(answer);
        bufferedWriter.newLine();
        bufferedWriter.flush();

        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        System.out.println("服务端退出----");
    }
}
