package com.itheima.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoLogin extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        String code = request.getParameter("code");

        String scode = (String) request.getSession().getAttribute("scode");

        if ("tom".equals(userName) && "123".equals(pwd)) {
            if (!code.equalsIgnoreCase(scode)) {
                request.setAttribute("msg", "验证码不对");
                request.getRequestDispatcher("/login.html").forward(request, response);
            }
            out.print("登录成功");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
