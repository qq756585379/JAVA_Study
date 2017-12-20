package com.itheima.web.servlet;


import com.itheima.domain.PageBean;
import com.itheima.service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PageServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //初始化每页显示的记录数
        int pageSize = 4;

        int currentPage = 1;//当前页
        String currPage = request.getParameter("currentPage");//从上一页或下一页得到的数据
        if (currPage != null && !"".equals(currPage)) {//第一次访问资源时，currPage可能是null
            currentPage = Integer.parseInt(currPage);
        }

        BookServiceImpl bs = new BookServiceImpl();
        //分页查询，并返回PageBean对象
        PageBean pb = bs.findBooksPage(currentPage, pageSize);

        request.setAttribute("pb", pb);
        request.getRequestDispatcher("/product_list.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}