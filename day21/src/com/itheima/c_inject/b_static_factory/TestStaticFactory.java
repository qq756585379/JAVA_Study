package com.itheima.c_inject.b_static_factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 静态工厂
 *
 */
public class TestStaticFactory {
	
	@Test
	public void demo01(){
		//自定义工厂
		UserService userService = MyBeanFactory.createService();
		userService.addUser();
	}
	
	@Test
	public void demo02(){
		//spring 工厂
		String xmlPath = "com/itheima/c_inject/b_static_factory/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserService userService = applicationContext.getBean("userServiceId" ,UserService.class);
		userService.addUser();
	}

}
