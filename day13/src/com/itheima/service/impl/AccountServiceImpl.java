package com.itheima.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.itheima.dao.AccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.domain.User;
import com.itheima.service.AccountService;
import com.itheima.util.C3P0Util;

public class AccountServiceImpl implements AccountService {

    public void transfer(String fromname, String toname, double money) {

        //	ad.updateAccount(fromname, toname, money);
        Connection conn = C3P0Util.getConnection();
        AccountDao ad = new AccountDaoImpl(conn);

        try {
            conn.setAutoCommit(false);
            User fromAccount = ad.findAccountByName(fromname);
            User toAccount = ad.findAccountByName(toname);

            fromAccount.setMoney(fromAccount.getMoney() - money);
            toAccount.setMoney(toAccount.getMoney() + money);

            ad.updateAccout(fromAccount);
//			int i = 10/0;
            ad.updateAccout(toAccount);
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
