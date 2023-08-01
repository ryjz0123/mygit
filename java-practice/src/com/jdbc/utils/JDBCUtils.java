package com.jdbc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2023/8/1 11:50
 * @工具类，完成 MySQL 的连接和关闭资源
 */
public class JDBCUtils {
    private static String user;      //用户名
    private static String password;   //密码
    private static String url;   //url
    private static String driver;   //驱动

    //在static代码块初始化
    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\mysql.properties"));

            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");

            Class.forName(driver);

        } catch (IOException e) {
            //将编译异常转成运行异常，这时调用者可以选择捕获该异常，也可以选择默认处理该异常
            throw new RuntimeException();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    //连接数据库，返回Connection
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //关闭相关资源
        /*
            1.Connection
            2.Statement 或 PreparedStatement
            3.ResultSet
         */
    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if (connection != null){
                connection.close();
            }
            if (statement != null){
                statement.close();
            }
            if (resultSet != null){
                resultSet.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
