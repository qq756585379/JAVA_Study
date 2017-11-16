package com.itheima.threadlocal;

public class TestThreadLocal {

    public static void main(String[] args) {
        ThreadLocal tl = new ThreadLocal();
        tl.set("p");

        MyThread mt = new MyThread(tl);
        mt.start();

        System.out.println(tl.get());
    }
}
