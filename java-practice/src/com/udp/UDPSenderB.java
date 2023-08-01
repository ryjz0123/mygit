package com.udp;

import java.io.IOException;
import java.net.*;

public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        //创建一个 DatagramSocket 对象，准备在9998接收数据
        DatagramSocket datagramSocket = new DatagramSocket(9998);
        //将需要发送的数据封装到 DatagramPacket 对象
        byte[] data = "hello 明天吃火锅".getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("169.254.56.229"), 9999);

        System.out.println("发送端B 发送数据...");
        datagramSocket.send(packet);

        byte[] buf = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(buf,buf.length);
        //调用接受方法，将通过网络传输的 DatagramPacket 对象，填充到 packet 对象
        datagramSocket.receive(packet1);
        int length = packet1.getLength();
        buf = packet.getData();
        String s = new String(buf,0,length);
        System.out.println(s);

        datagramSocket.close();
        System.out.println("B端退出");
    }
}
