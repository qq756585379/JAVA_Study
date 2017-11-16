package com.itheima.dao.impl;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.dao.AccountDao;
import com.itheima.util.C3P0Util;

public class AccountDaoImpl implements AccountDao {

    public void updateAccount(String fromname, String toname, double money) throws Exception {

        //转出账户-money，转入账户+money
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("update users set money=money-? where name=?", money, fromname);
        qr.update("update users set money=money+? where name=?", money, toname);
    }

}
