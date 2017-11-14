package com.itheima.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.itheima.domain.User;
import com.itheima.domain.UserForm;
import com.itheima.exception.UserExistException;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;

public class RegServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        UserForm uf = new UserForm();

        try {
            BeanUtils.populate(uf, request.getParameterMap());
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        if (!uf.validate()) {
            request.setAttribute("uf", uf);
            request.getRequestDispatcher("/regist.jsp").forward(request, response);
            return;
        }

        User user = new User();
        try {
            /* 原始方式
             * ConvertUtils.register(new Converter() {
			 * public Object convert(Class type, Object value) {
			 * Date date1 = null;
			 * if(value instanceof String){
			 * String date = (String) value;
			 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 * try {
			 * date1 = sdf.parse(date);
			 * } catch (ParseException e) {
			 * e.printStackTrace();
			 * }
			 * } return date1;
			 * }
			 * }, Date.class);
			 */

            //注册类型转换器
            ConvertUtils.register(new DateLocaleConverter(), Date.class);
            BeanUtils.populate(user, request.getParameterMap());
            UserService us = new UserServiceImpl();
            boolean isExist = us.findUserByName(user.getName());
            if (isExist) {
                //此处不需要做判断，因为在UserServiceImpl 里 throw new UserExistException("user has exit");
                request.setAttribute("error", "该用户已经存在");
                request.getRequestDispatcher("/regist.jsp").forward(request, response);
            } else {
                us.register(user);
            }
        } catch (UserExistException e) {
            request.setAttribute("error", "该用户已经存在");
            request.getRequestDispatcher("/regist.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().write("注册成功");
        response.setHeader("refresh", "1;url=" + request.getContextPath() + "/index.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
