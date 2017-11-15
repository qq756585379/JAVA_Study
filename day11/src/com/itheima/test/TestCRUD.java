package com.itheima.test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.itheima.utils.C3P0Util;
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
}
