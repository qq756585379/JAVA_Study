package com.itheima.attributelistener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class MyServletRequestListener implements ServletRequestAttributeListener {

    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("ServletRequest添加属性了");
    }

    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("ServletRequest移除属性了");
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae) {//参数代表事件源对象
        System.out.println("ServletRequest替换属性了");
        System.out.println(srae.getName()+"\t"+srae.getValue());
    }

}
