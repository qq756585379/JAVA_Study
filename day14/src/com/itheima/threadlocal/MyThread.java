package com.itheima.threadlocal;

public class MyThread extends Thread {

    private ThreadLocal tl;

    public MyThread(ThreadLocal tl) {
        this.tl = tl;
    }

    @Override
    public void run() {
        //tl.get() == null,tl里是局部变量，在其他线程访问不到，线程安全
        System.out.println(tl.get() + "aaaaaaaaaaaa");
    }

}
