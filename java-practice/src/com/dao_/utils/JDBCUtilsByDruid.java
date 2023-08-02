package com.dao_.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2023/8/1 17:06
 * @基于druid数据库连接池的工具类
 */
public class JDBCUtilsByDruid {
    private static DataSource dataSource;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    //编写getConnection方法
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    //关闭连接(把使用的Connection对象放回连接池)
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
