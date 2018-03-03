package com.itheima.f_xml.a_constructor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCons {
	
	@Test
	public void demo02() throws Exception{
		//spring 工厂
		String xmlPath = "com/itheima/f_xml/a_constructor/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		User user = (User) applicationContext.getBean("userId");
		System.out.println(user);
	}

}
