package com.itheima.web.servlet;

import com.itheima.service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DelAllBooksServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //得到所有id
        String[] ids = request.getParameterValues("ids");

        String path = request.getRemoteAddr();
        System.out.println(path + "我保证不打死你！");

        //调用删除业务
        BookServiceImpl bs = new BookServiceImpl();
        bs.deleAllBooks(ids);

        request.getRequestDispatcher("bookListServlet").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
