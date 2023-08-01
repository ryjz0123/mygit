package com.jdbc.myjdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2023/8/1 10:42
 * @注释
 */
public class PreStatement_exercise {
    private static Connection connection;
    public static void main(String[] args) throws Exception{

        getConnection();

//        String sql = "create table admin (username varchar(32),password varchar(32))" +
//                "CHARACTER SET utf8 COLLATE utf8_bin engine INNODB;";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);

//        int i = preparedStatement.executeUpdate();
//        if (i == 0){
//            System.out.println("表创建成功");
//        }else {
//            System.out.println("表创建失败");
//        }
        PreparedStatement preparedStatement  = connection.prepareStatement("");
        preparedStatement.addBatch("insert into admin values('tom','111')");
        preparedStatement.addBatch("insert into admin values('lisa','222')");
        preparedStatement.addBatch("insert into admin values('jhon','333')");
        preparedStatement.addBatch("insert into admin values('jerry','444')");
        preparedStatement.addBatch("insert into admin values('lucy','555')");
        int[] executed = preparedStatement.executeBatch();
    }

    public static void getConnection(){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\mysql.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(url, user, password);
            if (!connection.isClosed()){
                System.out.println("连接建立成功");
            }else {
                System.out.println("连接建立失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
