package com.itheima.test;

import com.itheima.service.AccountService;
import com.itheima.service.impl.AccountServiceImpl;

public class TestTransfer {

    public static void main(String[] args) throws Exception {
        AccountService as = new AccountServiceImpl();
        as.transfer("aaa", "bbb", 100);
    }

}
