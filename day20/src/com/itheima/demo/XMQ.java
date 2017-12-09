package com.itheima.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class XMQ {

    public static void main(String[] args) {

        KindWomen kw = new YPX();

//        kw.doSomething(123);
//        kw.throwEye(456);


//        final YPX y = new YPX();
//        KindWomen wp = new WP(y);

//		Proxy.newProxyInstance():产生代理类的实例。仅能代理实现至少一个接口的类
//		ClassLoader：类加载器。固定写法，和被代理类使用相同的类加载器即可。
//		Class[] interface：代理类要实现的接口。固定写法，和被代理类使用相同的接口即可。
//		InvocationHandler：策略（方案）设计模式的应用。如何代理？
        KindWomen proxy = (KindWomen) Proxy.newProxyInstance(kw.getClass().getClassLoader(), kw.getClass().getInterfaces(), new InvocationHandler() {
            //            InvocationHandler中的invoke方法：调用代理类的任何方法，此方法都会执行
//			  Object proxy:代理对象本身的引用。一般用不着。
//			  Method method:当前调用的方法。
//			  Object[] args:当前方法用到的参数

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("拿了钱");
                Object o = method.invoke(kw, new Object[]{(Double) args[0] / 2});
                System.out.println("后继事情。。。");
                return o;
            }
        });

        proxy.throwEye(5);


        proxy.doSomething(10);

    }
}