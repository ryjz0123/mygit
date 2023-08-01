package com.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        //创建一个 DatagramSocket 对象，准备在9999接收数据
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        //构建一个 DatagramPacket 对象，准备接收数据
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf,buf.length);
        //调用接受方法，将通过网络传输的 DatagramPacket 对象，填充到 packet 对象
        System.out.println("接受端A 等待接收数据...");
        datagramSocket.receive(packet);
        int length = packet.getLength();
        buf = packet.getData();
        String s = new String(buf,0,length);
        System.out.println(s);


        byte[] data = "好的 明天见".getBytes();
        DatagramPacket packet1 = new DatagramPacket(data, data.length, InetAddress.getByName("169.254.56.229"), 9998);
        datagramSocket.send(packet1);
        datagramSocket.close();
        System.out.println("A端退出");
    }
}
