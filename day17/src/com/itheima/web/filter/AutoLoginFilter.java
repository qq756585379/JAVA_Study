package com.itheima.web.filter;

import com.itheima.domain.User;
import com.itheima.service.UserService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutoLoginFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("AutoLoginFilter---init");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // 1、转换两个对象HttpServletRequest，HttpServletResponse
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        System.out.println("uri---" + uri);

        String path = req.getContextPath();
        System.out.println("path---" + path);

        path = uri.substring(path.length());
        System.out.println("path---" + path);

        //如果请求的资源不是login.jsp，也不是/servlet/loginServlet，就进入过滤,去数据库查找有没有用户信息
        if (!("/login.jsp".equals(path) || "/servlet/loginServlet".equals(path))) {
            User user = (User)req.getSession().getAttribute("user");
            //如果session得到了user对象，说明已经登录过或自动登录过。
            //那么请求下一个资源时就不用执行自动登录了。
            //用户没有登录过，我们才执行自动登录
            if (user == null) {
                System.out.println("need to login");
                // 2、处理业务
                // 得到cookies数组
                Cookie[] cookies = req.getCookies();
                String username = "";
                String password = "";
                // 从数组中找到想要的user对象的信息，Cookie中保存了登录信息才能自动登录
                for (int i = 0; cookies != null && i < cookies.length; i++) {
                    if ("user".equals(cookies[i].getName())) {
                        String value = cookies[i].getValue();// 存进去的格式是  aaa&123
                        String[] values = value.split("&");
                        username = values[0];
                        password = values[1];
                    }
                }

                // 登录操作
                UserService us = new UserService();
                User u = us.findUser(username, password);
                // 如果登录成功，把用户信息存到session中
                if (u != null) {
                    req.getSession().setAttribute("user", u);
                }
            }
        }
        // 3、放行
        chain.doFilter(request, response);
    }

    public void destroy() {
        System.out.println("AutoLoginFilter---destroy");
    }
}
