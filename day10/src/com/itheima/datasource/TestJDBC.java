package com.itheima.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;

public class TestJDBC {
    @Test
    public void test1() {

        Connection conn = null;
        PreparedStatement ps = null;
        DataSource ds = new MyDataSource();

        try {
            conn = ds.getConnection();
            ps = conn.prepareStatement("..");
//			...
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
