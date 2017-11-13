package com.itheima.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.domain.User;
import com.itheima.exception.UsersException;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        User user = new User();

        try {
            BeanUtils.populate(user, request.getParameterMap());
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        UserService us = new UserServiceImpl();

        User u;
        try {
            u = us.login(user);

            if (u != null) {
                request.getSession().setAttribute("u", user);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else {

                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (UsersException e) {
            e.printStackTrace();
        }


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
