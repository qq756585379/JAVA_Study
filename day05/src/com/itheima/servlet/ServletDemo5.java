package com.itheima.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo5 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String str = "aaaaa";

        System.out.println("A:我想办事");
        System.out.println("B:我办不了，但我可以找人帮你办");

        request.setAttribute("s", str);

//        request.getRequestDispatcher("/servlet/demo6").forward(request, response);
        //不能跳转别的应用
        //request.getRequestDispatcher("http://www.baidu.com").forward(request, response);

        //response.sendRedirect(request.getContextPath()+"/servlet/demo6");
        //response.sendRedirect("http://www.baidu.com");

        //请求包含
        request.getRequestDispatcher("/servlet/demo6").include(request, response);
        System.out.println("B:事办完了");

        /*请求转发：
        可以传递参数
        不能跳转其他应用
        地址栏不变
        转发过程是servlet和servlet交互，demo5请求demo6后再回来
        */

        /*重定向:
        是访问新的链接不能传递参数
        能跳转其他应用
        重定向过程中是跳转新的链接
        */
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
