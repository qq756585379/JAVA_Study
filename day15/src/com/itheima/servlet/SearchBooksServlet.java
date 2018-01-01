package com.itheima.servlet;

import com.itheima.domain.Book;
import com.itheima.service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchBooksServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");//只能解决post方式的乱码
        response.setContentType("text/html;charset=UTF-8");

        //获取表单数据
        String id = request.getParameter("id");
        String category = request.getParameter("category");
        String name = request.getParameter("name");
        String minprice = request.getParameter("minprice");
        String maxprice = request.getParameter("maxprice");

        //调用业务逻辑
        BookServiceImpl bs = new BookServiceImpl();
        List<Book> list = bs.searchBooks(id, category, name, minprice, maxprice);

        System.out.println("SearchBooksServlet = " + list);
        //分发转向
        request.setAttribute("books", list);//把list放入request对象中
        request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
