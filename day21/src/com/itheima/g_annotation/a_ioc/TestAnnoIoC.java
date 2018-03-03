package com.itheima.g_annotation.a_ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnoIoC {
	
	@Test
	public void demo02(){
		//从spring容器获得
		String xmlPath = "com/itheima/g_annotation/a_ioc/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserService userService = (UserService) applicationContext.getBean("userServiceId");
		userService.addUser();
		
	}

}
