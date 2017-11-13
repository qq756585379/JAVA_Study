package com.itheima.service;

import com.itheima.domain.User;
import com.itheima.exception.UserExistException;
import com.itheima.exception.UsersException;

public interface UserService {

	public void register(User user) throws Exception;

	public User login(User user) throws UsersException;

	public boolean findUserByName(String name) throws UserExistException;
}
