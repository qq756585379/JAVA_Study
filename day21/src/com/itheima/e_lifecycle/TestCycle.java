package com.itheima.e_lifecycle;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCycle {
	
	@Test
	public void demo02() throws Exception{
		//spring 工厂
		String xmlPath = "com/itheima/e_lifecycle/beans.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserService userService = (UserService) applicationContext.getBean("userServiceId");
		userService.addUser();
		
		//要求：1.容器必须close，销毁方法执行; 2.必须是单例的
//		applicationContext.getClass().getMethod("close").invoke(applicationContext);
		// * 此方法接口中没有定义，实现类提供
		applicationContext.close();
		
	}

}
