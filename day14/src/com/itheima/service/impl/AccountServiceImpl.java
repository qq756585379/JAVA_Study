package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.domain.User;
import com.itheima.service.AccountService;
import com.itheima.util.ManagerThreadLocal;

public class AccountServiceImpl implements AccountService {

    public void transfer(String fromname, String toname, double money) {
        //	ad.updateAccount(fromname, toname, money);
        AccountDao ad = new AccountDaoImpl();

        try {
            ManagerThreadLocal.startTransacation();//begin
            User fromAccount = ad.findAccountByName(fromname);
            User toAccount = ad.findAccountByName(toname);

            fromAccount.setMoney(fromAccount.getMoney() - money);
            toAccount.setMoney(toAccount.getMoney() + money);

            ad.updateAccout(fromAccount);
//			int i = 10/0;
            ad.updateAccout(toAccount);

            ManagerThreadLocal.commit();
        } catch (Exception e) {
            try {
                ManagerThreadLocal.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                ManagerThreadLocal.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
