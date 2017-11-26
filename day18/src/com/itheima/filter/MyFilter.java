package com.itheima.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {

    public MyFilter() {
        System.out.println("MyFilter实例化了");
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter初始化了");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        System.out.println("MyFilter1拦截开始了");
        //放行
        chain.doFilter(request, response);
        System.out.println("拦截结束了");
    }

    public void destroy() {
        System.out.println("MyFilter销毁了");
    }

}
