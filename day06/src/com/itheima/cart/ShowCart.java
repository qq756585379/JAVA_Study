package com.itheima.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheima.entity.Book;

public class ShowCart extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.print("购物车有以下商品：<br/>");

        //如果禁用了cookie就需要通过session传递数据
        HttpSession session = request.getSession();
        List<Book> books = (List<Book>) session.getAttribute("cart");

        if (books == null) {
            out.print("购物车为空");
            response.setHeader("refresh", "2;url=" + request.getContextPath() + "/servlet/showAllBooksServlet");
            //response.sendRedirect(request.getContextPath()+"/servlet/showAllBooksServlet");
            return;
        }

        for (Book book : books) {
            out.write(book.getName() + "<br/>");
        }

        //设置session的有效时间
        //session.setMaxInactiveInterval(10);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
