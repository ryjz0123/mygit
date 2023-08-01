package com.jdbc.myjdbc;

import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2023/7/31 13:56
 * @注释
 */
public class JdbcConnect {
    public static void main(String[] args) {

    }
    @Test
    public void connect01() throws SQLException {
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/db02";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","020507");
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    @Test
    public void connect02() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //利用反射加载Driver类，动态加载，更灵活，减少依赖
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/db02";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","020507");
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    @Test
    public void connect03() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/db02";
        String user = "root";
        String pwd = "020507";

        //注册Driver加载驱动
        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection(url, user, pwd);

        System.out.println(connection);
    }

    //使用Class.forName自动完成注册驱动
    @Test
    public void connect04() throws ClassNotFoundException, SQLException {

        //在加载Driver类时，完成注册
        /*
            Driver.class 源码：
            1.static 类加载时执行
            static {
                try {
                    DriverManager.registerDriver(new Driver());
                } catch (SQLException var1) {
                    throw new RuntimeException("Can't register driver!");
                }
            }
         */
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/db02";
        String user = "root";
        String pwd = "020507";

        Connection connection = DriverManager.getConnection(url, user, pwd);

        System.out.println(connection);
    }

    //增加配置文件，让连接MySQL更加灵活
    @Test
    public void connect05() throws IOException, ClassNotFoundException, SQLException {
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


    }
}
