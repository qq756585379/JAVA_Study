package com.itheima.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoLoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        String remember = request.getParameter("remember");

        Cookie ck = new Cookie("userName", userName);
        ck.setPath("/");

        if ("tom".equals(userName) && "123".equals(pwd)) {
            if (remember != null) {
                ck.setMaxAge(Integer.MAX_VALUE);
            } else {
                ck.setMaxAge(0);
            }
            response.addCookie(ck);
            out.write("登录成功！");
        } else {
            out.write("登录失败！");
            response.setHeader("refresh", "2;url=" + request.getContextPath() + "/servlet/login");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
