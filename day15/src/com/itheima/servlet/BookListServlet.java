package com.itheima.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Book;
import com.itheima.service.BookServiceImpl;

public class BookListServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        BookServiceImpl bsi = new BookServiceImpl();
        List<Book> list = bsi.findAllBooks();

        for (Book book : list) {
            System.out.println("xxxx = " + book.getName());
            String value = new String(book.getName().getBytes("iso-8859-1"), "utf-8");
            System.out.println("yyyy = " + value);
        }

        if (list != null) {
            request.setAttribute("books", list);
            request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
