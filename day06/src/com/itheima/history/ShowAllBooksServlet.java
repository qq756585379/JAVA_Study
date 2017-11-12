package com.itheima.history;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.entity.Book;
import com.itheima.util.DBUtil;

public class ShowAllBooksServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.write("本网站所有好书<br/>");
        Map<String, Book> books = DBUtil.findAllBooks();
        for (Map.Entry<String, Book> book : books.entrySet()) {
            out.write("<a href='" + request.getContextPath() + "/servlet/showBookDetail?id=" + book.getKey() + "' target='_blank'>" + book.getValue().getName() + "</a><br/>");
        }

        out.write("<hr/>您最近浏览的书<br/>");

        Cookie[] cookies = request.getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if ("historyBookId".equals(cookies[i].getName())) {
                String value = cookies[i].getValue(); // 1-2-3
                String[] ids = value.split("-");
                for (int j = 0; j < ids.length; j++) {
                    Book book = DBUtil.findBookById(ids[j]);
                    out.print(book.getName() + "<br/>");
                }
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
