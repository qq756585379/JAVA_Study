package com.itheima.f_xml.c_p;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestP {

    @Test
    public void demo01() {
        //从spring容器获得
        String xmlPath = "com/itheima/f_xml/c_p/beans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        Person person = (Person) applicationContext.getBean("personId");

        System.out.println(person);

    }

}
