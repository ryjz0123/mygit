package com.jdbc.myjdbc;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2023/7/31 12:00
 * @注释
 */
public interface JdbcInterface {
    //连接
    public Object getConnection();
    public void crud();
    public void close();
}
