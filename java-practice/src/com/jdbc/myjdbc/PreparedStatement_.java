package com.jdbc.myjdbc;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Date;
import java.util.Properties;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2023/7/31 22:07
 * @注释
 */
public class PreparedStatement_ {
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
        // ? 相当于占位符
        //String sql = "select id,name,sex from actor where id=? and name=? and sex=?";
        //添加记录
        //String sql = "insert into actor values(?,?,?,?,?)";

        //修改记录
        //String sql = "update actor set name = ? where id = ?";

        //删除记录
        String sql = "delete from actor where id = ?";

        //preparedStatement 对象实现了 PreparedStatement 接口的实现类的对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //给 ？ 赋值
//        preparedStatement.setString(1,"5");
//        preparedStatement.setString(2,"刘亦菲");
//        preparedStatement.setString(3,"女");
//        preparedStatement.setString(4,"1993-12-1");
//        preparedStatement.setString(5,"1248734");


//        preparedStatement.setString(1,"周星驰");
//        preparedStatement.setString(2,"2");
        preparedStatement.setString(1,"3");


        //执行select语句用executeQuery，执行dml(update,insert,delete)用executeUpdate
//        ResultSet resultSet = preparedStatement.executeQuery();
//        if (resultSet.next()){
//            System.out.println("查询成功");
//        }else {
//            System.out.println("失败");
//        }

        int rows = preparedStatement.executeUpdate();
        System.out.println(rows > 0 ? "成功" : "失败");
        connection.close();
        //resultSet.close();
        preparedStatement.close();
    }
}
