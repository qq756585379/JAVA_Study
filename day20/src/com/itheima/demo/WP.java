package com.itheima.demo;

public class WP implements KindWomen {

    private KindWomen kw;

    public WP(KindWomen kw) {
        this.kw = kw;
    }

    public void throwEye(double money) {
        kw.throwEye(money);
    }

    public void doSomething(double money) {
        kw.doSomething(money);
    }
}