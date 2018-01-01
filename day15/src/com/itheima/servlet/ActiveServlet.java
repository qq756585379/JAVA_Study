package com.itheima.servlet;

import com.itheima.exception.UserException;
import com.itheima.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ActiveServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 处理响应乱码
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        response.setContentType("text/html;charset=utf-8");

        HttpSession session = request.getSession();
        String activeCode = (String) session.getAttribute("activeCode");

        System.out.println("activeCode = " + activeCode);
        UserService us = new UserService();
        try {
            us.activeUser(activeCode);
            request.getRequestDispatcher("/activesuccess.jsp").forward(request, response);
        } catch (UserException e) {
            e.printStackTrace();
            //用户提示失败信息
            response.getWriter().write(e.getMessage());
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}

