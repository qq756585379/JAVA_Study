package com.itheima.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheima.entity.Book;
import com.itheima.util.DBUtil;

public class AddCart extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");
        Book book = DBUtil.findBookById(id);

        //如果禁用了cookie就需要通过session传递数据
        HttpSession session = request.getSession();

        List<Book> list = (List<Book>) session.getAttribute("cart");
        if (list == null) {
            list = new ArrayList<Book>();
        }
        list.add(book);

        session.setAttribute("cart", list);

        out.print("加入购物车成功！");
        String url = request.getContextPath() + "/servlet/showAllBooksServlet";
        response.setHeader("refresh", "2;url=" + response.encodeURL(url));

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
