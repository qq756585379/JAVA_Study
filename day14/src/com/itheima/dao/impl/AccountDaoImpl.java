package com.itheima.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.dao.AccountDao;
import com.itheima.domain.User;
import com.itheima.util.C3P0Util;
import com.itheima.util.ManagerThreadLocal;

public class AccountDaoImpl implements AccountDao {

    public void updateAccount(String fromname, String toname, double money) throws Exception {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("update account set money=money-? where name=?", money, fromname);
        qr.update("update account set money=money+? where name=?", money, toname);
    }

    public void updateAccout(User account) throws Exception {
        QueryRunner qr = new QueryRunner();
        qr.update(ManagerThreadLocal.getConnection(), "update account set money=? where name=?", account.getMoney(), account.getName());
    }

    public User findAccountByName(String name) throws Exception {
        QueryRunner qr = new QueryRunner();
        return qr.query(ManagerThreadLocal.getConnection(), "select * from account where name=?", new BeanHandler<User>(User.class), name);
    }

}
