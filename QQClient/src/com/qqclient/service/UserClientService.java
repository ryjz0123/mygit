package com.qqclient.service;

import com.qqcommon.Message;
import com.qqcommon.MessageType;
import com.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2023/7/29 14:08
 * @该类完成用户登录验证和用户注册等功能
 */
public class UserClientService {
    private User u = new User();
    private Socket socket;

    //根据userId 和 pwd 到服务器验证该用户是否合法
    public boolean checkUser(String userId,String pwd){
        //创建User对象
        u.setUserId(userId);
        u.setPassword(pwd);

        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream()); //得到ObjectOutputStream对象
            oos.writeObject(u);  //发送User对象

            //读取从服务器回复的Message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message) ois.readObject();

            if (ms.getMesType().equals(MessageType.MESSAGE_lOGIN_SUCCEED)){  //登录成功
                //创建一个和服务器端保持通信的线程 --》 创建一个类 ClientConnectServerThread

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
