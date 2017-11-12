package com.itheima.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String userName = "";
        String checked = "";

        Cookie[] cookies = request.getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if ("userName".equals(cookies[i].getName())) {
                userName = cookies[i].getValue();
                checked = "checked='checked'";
            }
        }

        out.write("<form action='" + request.getContextPath() + "/servlet/doLogin' method='post'>");
        out.write("用户名：<input type='text' name='userName' value='" + userName + "'/><br/>");
        out.write("密码：<input type='password' name='pwd'/><br/>");
        out.write("<input type='checkbox' name='remember' " + checked + "/><br/>");
        out.write("<input type='submit' value='提交'/><br/>");
        out.write("</form>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
