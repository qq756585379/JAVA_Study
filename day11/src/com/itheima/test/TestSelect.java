package com.itheima.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itheima.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.itheima.entity.User;

public class TestSelect {

    @Test
    public void testSelect() throws SQLException {

        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        List<User> list = qr.query("select * from users", new ResultSetHandler<List<User>>() {
            public List<User> handle(ResultSet rs) throws SQLException {
                List<User> list = new ArrayList<User>();
                while (rs.next()) {
                    User u = new User();
                    u.setId(rs.getInt(1));
                    u.setName(rs.getString(2));
                    u.setPassword(rs.getString(3));
                    u.setEmail(rs.getString(4));
                    u.setBirthday(rs.getDate(5));
                    list.add(u);
                }
                return list;
            }
        });

        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelect2() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        List<User> list = qr.query("select * from users where id=? and name=?", new BeanListHandler<User>(User.class), 8, "jerry");

        for (User user : list) {
            System.out.println(user);
        }
    }
}
