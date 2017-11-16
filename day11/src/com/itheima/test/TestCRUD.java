package com.itheima.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.itheima.entity.User;
import com.itheima.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

public class TestCRUD {

    @Test
    public void testInsert() {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = C3P0Util.getConnection();
            ps = conn.prepareStatement("insert into users(name,password,email,birthday) values('zss','123456','zs@sina.com','1980-12-04')");
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            C3P0Util.release(conn, ps, null);
        }
        System.out.println(conn.getClass().getName());
    }

    @Test
    public void testInsert2() throws SQLException {
        //创建一个QueryRunner对象，要导入 commons-dbutils-1.4.jar
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        //执行sql语句
        qr.update("insert into users(name,password,email,birthday) values(?,?,?,?)", "菜10", "123", "c10@163.com", new Date());
    }

    @Test
    public void testUpdate() throws SQLException {
        //创建一个QueryRunner对象
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("update users set name=?,password=?,money=? where id=?", "aaa", "333", 8, 1);
    }

    @Test
    public void testDelete() throws SQLException {
        //创建一个QueryRunner对象
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("delete from users where id=?", 9);
    }

    @Test//批处理，只能执行相同的sql语句
    public void testBatch() throws SQLException {
        //创建一个QueryRunner对象
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        Object[][] params = new Object[10][];//高维代表执行多少次sql语句
        for (int i = 0; i < params.length; i++) {
            params[i] = new Object[]{"菜10" + i, "123", "c10@163.com", new Date()};//给每次执行的sql语句中的？赋值
        }
        qr.batch("insert into users(name,password,email,birthday) values(?,?,?,?)", params);
    }

    @Test
    public void testSelect() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        List<User> list = queryRunner.query("select * from users", new BeanListHandler<User>(User.class));

        for (User user : list) {
            System.out.println(user);
        }

    }
}
