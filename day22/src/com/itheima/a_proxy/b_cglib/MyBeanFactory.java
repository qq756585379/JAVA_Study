package com.itheima.a_proxy.b_cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MyBeanFactory {

    public static UserServiceImpl createService() {
        //1 目标类
        final UserServiceImpl userService = new UserServiceImpl();
        //2切面类
        final MyAspect myAspect = new MyAspect();
        // 3.代理类 ，采用cglib，底层创建目标类的子类
        //3.1 核心类
        Enhancer enhancer = new Enhancer();
        //3.2 确定父类
        enhancer.setSuperclass(userService.getClass());
        /* 3.3 设置回调函数 , MethodInterceptor接口 等效 jdk InvocationHandler接口
         * 	intercept() 等效 jdk  invoke()
		 * 		参数1、参数2、参数3：以invoke一样
		 * 		参数4：methodProxy 方法的代理
		 * 		
		 *
		 *   如果没有接口，采用cglib 字节码增强
		 */
        enhancer.setCallback(new MethodInterceptor() {

            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

                //前
                myAspect.before();

                //执行目标类的方法
                Object obj = method.invoke(userService, args);
                // * 执行代理类的父类 ，执行目标类 （目标类和代理类 父子关系）
                methodProxy.invokeSuper(proxy, args);

                //后
                myAspect.after();

                return obj;
            }
        });

        //3.4 创建代理
        UserServiceImpl proxService = (UserServiceImpl) enhancer.create();

        return proxService;
    }

}
