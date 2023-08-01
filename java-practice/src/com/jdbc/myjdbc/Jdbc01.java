package com.jdbc.myjdbc;


import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2023/7/31 12:42
 * @注释
 */
public class Jdbc01 {
    public static void main(String[] args) throws SQLException {
        //注册驱动
        Driver driver = new Driver();
        //得到连接
        //jdbc:mysql:// 表示协议，通过jdbc的方式连接mysql
        String url = "jdbc:mysql://localhost:3306/db02";
        //将用户名和密码放入到Properties对象
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","020507");
        Connection connect = driver.connect(url, properties);

        //执行sql
        String sql = "insert into actor values(null, '刘德华','男','1970-9-19','1092830')";
        //statement 用于执行静态SQL语句并返回其生成结果的对象
        Statement statement = connect.createStatement();
        //
        int rows = statement.executeUpdate(sql);
        if (rows > 0) {
            System.out.println("成功");
        }
        //关闭连接
        connect.close();
        statement.close();
    }
}
