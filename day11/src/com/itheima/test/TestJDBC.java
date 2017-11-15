package com.itheima.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.itheima.utils.DBCPUtil;

public class TestJDBC {
    @Test
    public void test1() {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBCPUtil.getConnection();
            ps = conn.prepareStatement("select * from users");
//            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBCPUtil.release(conn, ps, null);
        }

    }
}
