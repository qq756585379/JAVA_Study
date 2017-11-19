package com.itheima.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.domain.Book;
import com.itheima.service.BookServiceImpl;
import com.itheima.util.UUIDUtil;

public class AddBookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Book book = new Book();
        try {
            BeanUtils.populate(book, request.getParameterMap());
            book.setId(UUIDUtil.getUUID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        BookServiceImpl bs = new BookServiceImpl();
        bs.addBook(book);

        request.getRequestDispatcher("bookListServlet").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
