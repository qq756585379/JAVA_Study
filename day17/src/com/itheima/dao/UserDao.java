package com.itheima.dao;

import com.itheima.domain.User;
import com.itheima.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {

    public User findUser(String username, String password) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        String sql = "select * from users where name=? and password=?";
        return qr.query(sql, new BeanHandler<User>(User.class), username, password);
    }

}
