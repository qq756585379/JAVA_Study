package com.itheima.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo1 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();//获得客户端所有cookie对象
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if ("lastAccessTime".equals(cookies[i].getName())) {
                long l = Long.parseLong(cookies[i].getValue());
                out.write("你的最后访问时间为：" + new Date(l).toLocaleString());//yyyy-MM-dd
            }
        }

        out.print("<a href='" + request.getContextPath() + "/servlet/clear'>clear</a>");

        //创建cookie并把信息写回客户端
        Cookie ck = new Cookie("lastAccessTime", System.currentTimeMillis() + "");
        ck.setMaxAge(60 * 5);
        //ck.setPath("/day06");
        //ck.setPath(request.getContextPath());//  /day06
        ck.setPath("/");//  /day06
        response.addCookie(ck);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
