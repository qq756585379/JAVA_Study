package com.itheima.demo3;

@MyTest
public class SomeDaoImpl {

    @MyTest(timeout = 1000000)
    public void testAdd() {
        System.out.println("add方法执行了");
    }

    @MyTest
    public void testUpdate() {
        System.out.println("update方法执行了");

    }

}
