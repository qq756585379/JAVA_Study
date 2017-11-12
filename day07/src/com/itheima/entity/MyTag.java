package com.itheima.entity;

import javax.servlet.jsp.PageContext;

public class MyTag {

    public void ff(PageContext pc) {

        pc.getRequest();
        pc.getSession();
        pc.getRequest();
    }
}
