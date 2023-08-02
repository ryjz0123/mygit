package com.dao_.dao;

import com.dao_.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2023/8/1 22:25
 * @注释
 */
public class BasicDAO<T> {  //泛型指定具体类型

    private QueryRunner queryRunner = new QueryRunner();

    //dml操作
    public int update(String sql,Object... parameters){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            int update = queryRunner.update(connection,sql,parameters);
            return update;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(connection,null,null);
        }
    }

    //返沪查询结果是多行
    public List<T> queryMulti(String sql, Class<T> tClass,Object... parameters){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            List<T> list = queryRunner.query(connection,sql,new BeanListHandler<T>(tClass),parameters);
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(connection,null,null);
        }
    }

    //返沪查询结果是单行
    public T querySingle(String sql, Class<T> tClass,Object... parameters){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return queryRunner.query(connection,sql,new BeanHandler<T>(tClass),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(connection,null,null);
        }
    }

    //返沪查询结果是单行单列
    public Object queryScalar(String sql, Object... parameters){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return queryRunner.query(connection,sql,new ScalarHandler(),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(connection,null,null);
        }
    }
}
