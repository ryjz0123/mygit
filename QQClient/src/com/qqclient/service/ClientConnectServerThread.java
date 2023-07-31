package com.qqclient.service;

import com.qqcommon.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2023/7/29 14:37
 * @注释
 */
public class ClientConnectServerThread extends Thread{
    //该线程需要持有socket
    private Socket socket;

    @Override
    public void run() {
        //Thread在后台和服务器通信
        while (true){
            System.out.println("客户端线程，等待读取从服务端发送的消息");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }
}
