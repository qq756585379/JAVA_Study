package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

import java.sql.SQLException;

public class UserService {
    UserDao ud = new UserDao();

    public User findUser(String username, String password) {
        try {
            return ud.findUser(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}