package com.itheima.test;

import com.itheima.service.AccountService;
import com.itheima.util.ObjectFactory;

public class TestTransfer {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        AccountService as = ObjectFactory.getAccountService();
        as.transfer("bbb", "aaa", 100);
    }
}

