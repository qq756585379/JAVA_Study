package com.itheima.pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class Test {

    //没实际开发意义
    public static void main(String[] args) {
        DataSource ds = new MyDataSource();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ds.getConnection();//com.mysql.jdbc.Connection
            ps = conn.prepareStatement("..");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();//不需要关闭，warper里的包装类可以调用该方法，因为包装内会把连接放回到pool里面
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
