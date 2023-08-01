package com.jdbc.myjdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Date;
import java.util.Properties;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2023/7/31 15:37
 * @注释
 */
public class ResultSet_ {
    public static void main(String[] args) throws Exception{
            //通过properties对象获取配置文件信息
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\mysql.properties"));
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driver = properties.getProperty("driver");

            Class.forName(driver);

            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection);

        Statement statement = connection.createStatement();
        String sql = "select id,name,sex,borndate from actor";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            int id = resultSet.getInt(1);  //取该行的第1列
            String name = resultSet.getString(2);  //取该行的第2列
            String sex = resultSet.getString(3);   //取该行的第3列
            Date date = resultSet.getDate(4);  //取该行的第4列
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + date);
        }


        resultSet.close();
        statement.close();
        connection.close();
    }
}
