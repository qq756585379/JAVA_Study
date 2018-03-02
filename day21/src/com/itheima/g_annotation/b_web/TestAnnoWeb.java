package com.itheima.g_annotation.b_web;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnoWeb {
	
	@Test
	public void demo02(){
		//从spring容器获得
		String xmlPath = "com/itheima/g_annotation/b_web/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		StudentAction studentAction = (StudentAction) applicationContext.getBean("studentActionId");
		
		studentAction.execute();
	}

}
