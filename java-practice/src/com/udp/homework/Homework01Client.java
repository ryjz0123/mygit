package com.udp.homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Homework01Client {
    public static void main(String[] args) throws IOException {
        //连接本机的9999端口，如果连接成功，返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //通过socket.getOutpitStream() 得到和 socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //通过输出流，写入数据到数据通道，使用字符流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        //从键盘读取用户的问题
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的问题：");
        String question = scanner.next();

        bufferedWriter.write(question);
        bufferedWriter.newLine();//插入一个换行符，表示写入的内容结束，要求对方使用readLine()
        bufferedWriter.flush();

        //获取和socket关联的输入流，读取数据并显示
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        //关闭流对象和socket
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        System.out.println("客户端退出-----");
    }
}
