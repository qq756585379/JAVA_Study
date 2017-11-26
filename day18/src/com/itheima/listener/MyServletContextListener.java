package com.itheima.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

    //监听域对象的创建何销毁
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext对象创建了");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext对象销毁了");
    }

}
