package com.itheima.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilterConfigTest implements Filter {

    private FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        //通过FilterConfig对象获取到配置文件中的初始化信息
        String encoding = filterConfig.getInitParameter("encoding");
        System.out.println(encoding);
        request.setCharacterEncoding(encoding);
        //放行
        chain.doFilter(request, response);
    }

    public void destroy() {
        // TODO Auto-generated method stub

    }

}

