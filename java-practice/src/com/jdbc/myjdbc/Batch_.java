package com.jdbc.myjdbc;

import com.jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2023/8/1 13:07
 * @注释
 */
public class Batch_ {
    public static void main(String[] args) {

    }
    @Test
    public void noBatch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin values(?,?)" ;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1,"jack"+i);
            preparedStatement.setString(2,i+"");
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时=" + (end - start));
        JDBCUtils.close(connection,preparedStatement,null);
    }
    @Test
    public void Batch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin values(?,?)" ;
        connection.setAutoCommit(false);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1,"jack"+i);
            preparedStatement.setString(2,i+"");
            preparedStatement.addBatch();
            if ((i+1) % 1000 == 0){
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时=" + (end - start));
        JDBCUtils.close(connection,preparedStatement,null);
    }
}
