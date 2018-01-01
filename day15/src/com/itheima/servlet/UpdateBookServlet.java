package com.itheima.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.apache.commons.beanutils.BeanUtils;

public class UpdateBookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("---------------" + request.getParameterMap());
        request.setCharacterEncoding("UTF-8");
        Product book = new Product();
        try {
            BeanUtils.populate(book, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }

        ProductService ps = new ProductService();
        ps.updateBook(book);

        request.getRequestDispatcher("/servlet/bookListServlet").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
