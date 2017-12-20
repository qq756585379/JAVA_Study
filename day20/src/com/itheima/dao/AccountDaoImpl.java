package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.util.C3P0Util;
import com.itheima.util.ManagerThreadLocal;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class AccountDaoImpl implements AccountDao {

    public void updateAccount(String fromname, String toname, double money) throws Exception {
        //创建一个QueryRunner对象
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("update users set money=money-? where name=?", money, fromname);
        qr.update("update users set money=money+? where name=?", money, toname);
    }

    public void updateAccout(Account account) throws Exception {
        QueryRunner qr = new QueryRunner();
        qr.update(ManagerThreadLocal.getConnection(), "update users set money=? where name=?", account.getMoney(), account.getName());
    }

    public Account findAccountByName(String name) throws Exception {
        QueryRunner qr = new QueryRunner();
        return qr.query(ManagerThreadLocal.getConnection(), "select * from users where name=?", new BeanHandler<Account>(Account.class), name);
    }

}
