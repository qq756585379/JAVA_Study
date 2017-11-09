package com.itheima.servlet;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.entity.User;
import org.apache.commons.beanutils.BeanUtils;

public class ServletDemo3 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //解决post乱码问题
        request.setCharacterEncoding("UTF-8");

        test1(request);
        System.out.println("-----------------");
        test2(request);
        System.out.println("-----------------");
        test3(request);
        System.out.println("-----------------");
        test4(request);
    }

    private void test4(HttpServletRequest request) {
        try {
            User u = new User();
            System.out.println("u==" + u);
            BeanUtils.populate(u, request.getParameterMap());
            System.out.println("u==" + u);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void test3(HttpServletRequest request) {
        try {
            User u = new User();
            System.out.println("u==" + u);
            Map<String, String[]> map = request.getParameterMap();

            for (Map.Entry<String, String[]> m : map.entrySet()) {
                String name = m.getKey();
                String[] value = m.getValue();

                PropertyDescriptor pd = new PropertyDescriptor(name, User.class);
                Method setter = pd.getWriteMethod();

                if (value.length == 1) {
                    setter.invoke(u, value[0]);         //给一个变量赋值
                } else {
                    setter.invoke(u, (Object) value);   //相当于给复选框赋值
                }
            }
            System.out.println("u==" + u);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void test2(HttpServletRequest request) {
        Enumeration names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            String[] values = request.getParameterValues(name);
            for (int i = 0; values != null && i < values.length; i++) {
                System.out.println(name + "\t" + values[i]);
            }
        }
    }

    private void test1(HttpServletRequest request) throws UnsupportedEncodingException {

        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        String sex = request.getParameter("sex");
        String[] hobbys = request.getParameterValues("hobby");
        String city = request.getParameter("city");
        //解决get乱码问题
        userName = new String(userName.getBytes("iso-8859-1"), "UTF-8");

        System.out.println(userName);
        System.out.println(pwd);
        System.out.println(sex);

        for (int i = 0; hobbys != null && i < hobbys.length; i++) {
            System.out.print(hobbys[i] + "\t");
        }

        System.out.println();
        System.out.println(city);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
