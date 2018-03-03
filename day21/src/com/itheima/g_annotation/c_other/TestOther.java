package com.itheima.g_annotation.c_other;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOther {

    @Test
    public void demo02() {
        //spring 工厂
        String xmlPath = "com/itheima/g_annotation/c_other/beans.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        UserService userService = applicationContext.getBean("userServiceId", UserService.class);
        UserService userService2 = applicationContext.getBean("userServiceId", UserService.class);

        System.out.println(userService);
        System.out.println(userService2);

        applicationContext.close();
    }

}
