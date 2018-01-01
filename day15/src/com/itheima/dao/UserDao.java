package com.itheima.dao;

import com.itheima.domain.User;
import com.itheima.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {

    public void addUser(User user) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        String sql = "INSERT INTO USER(username,PASSWORD,gender,email,telephone,introduce,activecode,state,registtime) "
                + "VALUES(?,?,?,?,?,?,?,?,?)";
        qr.update(sql, user.getUsername(), user.getPassword(),
                user.getGender(), user.getEmail(), user.getTelephone(),
                user.getIntroduce(), user.getActiveCode(), user.getState(),
                user.getRegistTime());
    }

    // 根据激活码查找用户
    public User findUserByActiveCode(String activeCode) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        return qr.query("select * from user where activecode=?", new BeanHandler<User>(User.class), activeCode);
    }

    // 修改用户激活状态
    public void activeCode(String activeCode) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("update user set state=1 where activecode=?", activeCode);
    }

    // 用户登录
    public User findUserByUserNameAndPassword(String username, String password)
            throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        return qr.query("select * from user where username=? and password=?",
                new BeanHandler<User>(User.class), username, password);
    }

    // 根据id查找用户
    public User findUserById(String id) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        return qr.query("select * from user where id=?", new BeanHandler<User>(User.class), id);
    }

    // 根据email查找用户
    public User findUserByEmail(String email) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        return qr.query("select * from user where email=?", new BeanHandler<User>(User.class), email);
    }

    // 修改用户信息
    public void modifyUser(User user) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("update user set password=? , gender=?, telephone=? where id=?",
                user.getPassword(), user.getGender(), user.getTelephone(), user.getId());

    }
}
