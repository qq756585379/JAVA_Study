package com.itheima.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("HttpSession对象创建了");
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("HttpSession对象销毁了");
    }

}