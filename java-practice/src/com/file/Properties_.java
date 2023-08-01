package com.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Properties_ {
    public static void main(String[] args) throws IOException {
        //创建properties对象
        Properties properties = new Properties();
        //加载指定配置文件
        properties.load(new FileReader("src\\mysql.properties"));
        //把k-v显示控制台
        properties.list(System.out);
        //根据key获取对应 的值
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("password");

        System.out.println(user + "\t" + pwd);

        properties.setProperty("charset","utf8");
        properties.setProperty("name","汤姆");
        properties.store(new FileOutputStream("src\\mysql.properties"),null);


    }
}
