package com.itheima.pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class Test {

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
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
