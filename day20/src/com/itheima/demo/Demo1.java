package com.itheima.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//注解
public class Demo1 {

    @SuppressWarnings("all")
    public void ff() {
        int i = 0;
        System.out.println("abc");
        List list = new ArrayList();
        System.out.println(new Date().toLocaleString());
    }

    public void l1l1lll1l1l1l1() {

    }

}

class Demo2 extends Demo1 {
    public void ff() {

    }

    @Deprecated
    public void l1l1lll1l1l1l1() {
        System.out.println(new Date().toLocaleString());
    }
}