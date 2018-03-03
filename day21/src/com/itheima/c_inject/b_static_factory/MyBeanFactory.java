package com.itheima.c_inject.b_static_factory;

public class MyBeanFactory {
	
	/**
	 * 创建实例
	 * @return
	 */
	public static UserService createService(){
		return new UserServiceImpl();
	}

}
