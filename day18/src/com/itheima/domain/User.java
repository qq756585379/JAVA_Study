package com.itheima.domain;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.io.Serializable;

public class User implements Serializable, HttpSessionBindingListener {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("user对象被绑定了");
    }

    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("user对象解除被绑定了");
    }


}

