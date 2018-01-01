package com.itheima.servlet;

import com.itheima.domain.Product;
import com.itheima.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class AddCartServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String id = request.getParameter("id");

        ProductService bs = new ProductService();

        Product book = bs.findBookById(id);

        //从session中的购物车取出 来
        HttpSession session = request.getSession();
        Map<Product, String> cart = (Map<Product, String>) session.getAttribute("cart");
        int num = 1;
        //如何是第一次访问，没有购物车对象，我们就创建 一个购物车对象
        if (cart == null) {
            cart = new HashMap<Product, String>();
        }
        //查看当前集合中是否存在b这本书,如果有就把数据取出来加1;
        if (cart.containsKey(book)) {
            num = Integer.parseInt(cart.get(book)) + 1;
        }
        //把图书放入购物车
        cart.put(book, num + "");

        //把cart对象放回到session作用域中
        session.setAttribute("cart", cart);

        PrintWriter out = response.getWriter();
        out.print("<a href='" + request.getContextPath() + "/pageServlet'>继续购物</a>，<a href='" + request.getContextPath() + "/cart.jsp'>查看购物车</a>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
