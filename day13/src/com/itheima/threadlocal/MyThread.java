package com.itheima.threadlocal;

public class MyThread extends Thread {

    private ThreadLocal tl;

    public MyThread(ThreadLocal tl) {
        this.tl = tl;
    }

    @Override
    public void run() {
        System.out.println(tl.get() + "aaaaaaaaaaaa");
    }

}
