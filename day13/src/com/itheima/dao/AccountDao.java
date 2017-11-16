package com.itheima.dao;

import com.itheima.domain.User;

public interface AccountDao {

    @Deprecated
    public void updateAccount(String fromname, String toname, double money) throws Exception;

    public void updateAccout(User accout) throws Exception;

    public User findAccountByName(String name) throws Exception;
}
