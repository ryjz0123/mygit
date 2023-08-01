package com.jdbc.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2023/8/1 15:30
 * @注释
 */
public class C3P0_ {
    //方式1：相关参数，在程序中指定，user，url，password等
    @Test
    public void testC3P0_01() throws Exception  {

        //创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //通过配置文件获取相关的连接信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        //给数据源 comboPooledDataSource 设置相关参数
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        //设置初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //设置最大连接数
        comboPooledDataSource.setMaxPoolSize(50);
        //getConnection() 从DataSource接口实现
        Connection connection = comboPooledDataSource.getConnection();

        System.out.println("连接成功");
        connection.close();
    }

    //方式2：使用配置文件模板
    @Test
    public void testC3P0_02() throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("C3P0");

        Connection connection = comboPooledDataSource.getConnection();
        System.out.println("连接成功");
        connection.close();
    }
}
