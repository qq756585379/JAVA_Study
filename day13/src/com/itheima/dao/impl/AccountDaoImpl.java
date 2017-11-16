package com.itheima.dao.impl;

import java.sql.Connection;

import com.itheima.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.dao.AccountDao;
import com.itheima.util.C3P0Util;

public class AccountDaoImpl implements AccountDao {

    private Connection conn;

    public AccountDaoImpl(Connection conn) {
        this.conn = conn;
    }

    public void updateAccount(String fromname, String toname, double money) throws Exception {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("update account set money=money-? where name=?", money, fromname);
        qr.update("update account set money=money+? where name=?", money, toname);
    }

    public void updateAccout(User account) throws Exception {
        QueryRunner qr = new QueryRunner();
        qr.update(conn, "update account set money=? where name=?", account.getMoney(), account.getName());
    }

    public User findAccountByName(String name) throws Exception {
        QueryRunner qr = new QueryRunner();
        return qr.query(conn, "select * from account where name=?", new BeanHandler<User>(User.class), name);
    }

}
