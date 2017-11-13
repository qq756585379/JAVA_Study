package com.itheima.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.utils.DBUtils;

public class UserDaoImpl implements UserDao {

    public void addUser(User user) throws Exception {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("INSERT INTO users(username,PASSWORD,email,birthday) VALUES(?,?,?,?)");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(user.getBirthday());
            ps.setString(4, date);

            int i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("���ʧ�ܣ�");
        } finally {
            DBUtils.closeAll(null, ps, conn);
        }
    }

    public User findUser(User user) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("select * from users where name=? and password=?");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            rs = ps.executeQuery();
            if (rs.next()) {
                u = new User();
                u.setId(rs.getInt(1));
                u.setUsername(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setBirthday(rs.getDate(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(rs, ps, conn);
        }
        return u;
    }

    public boolean findUserByName(String name) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("select * from users where username=?");
            ps.setString(1, name);

            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(rs, ps, conn);
        }
        return false;
    }

}
