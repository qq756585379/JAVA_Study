package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.AccountService;

public class AccountServiceImpl implements AccountService {

    AccountDao ad = new AccountDaoImpl();

    public void transfer(String fromname, String toname, double money)
            throws Exception {
        ad.updateAccount(fromname, toname, money);
    }

}
