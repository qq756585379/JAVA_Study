package com.itheima.servlet;

import com.itheima.domain.Book;
import com.itheima.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class ChangeNumServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String num = request.getParameter("num");
        //注：只能重写id的hashcode
        Product book = new Product();
        book.setId(id);

        HttpSession session = request.getSession();
        Map<Product, String> cart = (Map<Product, String>) session.getAttribute("cart");
        //如果商品数据为0，就删除对象
        if ("0".equals(num)) {
            cart.remove(book);
        }
        //判断如果找到与id相同的书，
        if (cart.containsKey(book)) {
            cart.put(book, num);
        }

        response.sendRedirect(request.getContextPath() + "/cart.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}

