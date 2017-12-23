package com.itheima.servlet;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ImageCodeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        //控制客户端不要缓存,不然随机验证码就不会变
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setIntHeader("Expires", 0);

        //使用第三方jar
        ValidateCode vc = new ValidateCode(110, 25, 4, 9);
        vc.write(resp.getOutputStream());
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
