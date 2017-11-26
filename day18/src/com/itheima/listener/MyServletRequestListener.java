package com.itheima.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequestListener implements ServletRequestListener {

    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("ServletRequest销毁了");
    }

    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("ServletRequest创建了");
    }

}