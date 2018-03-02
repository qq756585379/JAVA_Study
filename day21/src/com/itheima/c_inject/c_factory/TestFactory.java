package com.itheima.c_inject.c_factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactory {
	
	@Test
	public void demo01(){
		//自定义实例工厂
		//1 创建工厂
		MyBeanFactory myBeanFactory = new MyBeanFactory();
		//2 通过工厂实例，获得对象
		UserService userService = myBeanFactory.createService();
		
		userService.addUser();
	}
	@Test
	public void demo02(){
		//spring 工厂
		String xmlPath = "com/itheima/c_inject/c_factory/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserService userService = applicationContext.getBean("userServiceId" ,UserService.class);
		userService.addUser();
	}

}
