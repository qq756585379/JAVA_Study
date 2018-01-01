package com.itheima.servlet;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ModifyUserServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //封装表单数据
        User user = new User();
        try {
            BeanUtils.populate(user, request.getParameterMap());

            UserService us = new UserService();
            us.modifyUser(user);

            request.getSession().invalidate();//相当于注消用户
            response.sendRedirect(request.getContextPath() + "/modifyUserInfoSuccess.jsp");
        } catch (Exception e) {
            response.getWriter().write(e.getMessage());
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
