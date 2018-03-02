package com.itheima.c_inject.c_factory;

/**
 * 实例工厂,所有方法非静态
 *
 */
public class MyBeanFactory {
	/**
	 * 创建实例
	 * @return
	 */
	public UserService createService(){
		return new UserServiceImpl();
	}
}
