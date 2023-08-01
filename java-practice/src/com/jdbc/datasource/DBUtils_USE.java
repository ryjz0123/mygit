package com.jdbc.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.jdbc.myjdbc.Jdbc01;
import com.jdbc.utils.JDBCUtilsByDruid;
import com.sun.javafx.scene.control.GlobalMenuAdapter;
import jdk.nashorn.internal.scripts.JD;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2023/8/1 18:51
 * @注释
 */
public class DBUtils_USE {
    @Test
    //使用apache-DBUtils工具类 + druid 完成对表的crud操作
    public void testQueryMany() throws Exception {
        Connection connection = JDBCUtilsByDruid.getConnection();
        //使用 DBUtils
        //创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from actor ";
        List<Actor> list = queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class));
        for (Actor actor :
                list) {
            System.out.println(actor);
        }
        JDBCUtilsByDruid.close(connection,null,null);
    }

    //单行数据
    @Test
    public void testQuerySingle() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        String sql = "select * from actor where id=?";
        QueryRunner queryRunner = new QueryRunner();
        Actor actor  = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 2);
        System.out.println(actor);

        JDBCUtilsByDruid.close(connection,null,null);

    }

    //单行单列
    @Test
    public void testScalar() throws Exception{

        Connection connection = JDBCUtilsByDruid.getConnection();
        String sql = "select name from actor where id=?";
        QueryRunner queryRunner = new QueryRunner();
        Object obj  = queryRunner.query(connection, sql, new ScalarHandler(), 2);
        System.out.println(obj);

        JDBCUtilsByDruid.close(connection,null,null);
    }

    //dml
    @Test
    public void testDML() throws Exception{

        Connection connection = JDBCUtilsByDruid.getConnection();
        String sql = "insert into actor values(?,?,?,?,?)";
        QueryRunner queryRunner = new QueryRunner();
        //返回受影响的行数
        int row = queryRunner.update(connection, sql, null, "杨紫", "女","1999-2-12", "1289847");

        System.out.println(row);

        JDBCUtilsByDruid.close(connection,null,null);
    }
}
