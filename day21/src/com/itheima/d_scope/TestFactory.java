package com.itheima.d_scope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactory {
	
	@Test
	public void demo02(){
		//spring 工厂
		String xmlPath = "com/itheima/d_scope/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserService userService = applicationContext.getBean("userServiceId" ,UserService.class);
		UserService userService2 = applicationContext.getBean("userServiceId" ,UserService.class);
		
		System.out.println(userService);
		System.out.println(userService2);
	}

}
