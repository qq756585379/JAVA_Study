package com.itheima.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;

public class ServletDemo4 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //控制客户端不要缓存,不然随机验证码就不会变
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setIntHeader("Expires", 0);

        //http://localhost:8080/day04/login.html
        //使用第三方jar
        ValidateCode vc = new ValidateCode(110, 25, 4, 9);
        vc.write(response.getOutputStream());

        //不使用第三方样式比较丑
//        test1(response);
    }

    private void test1(HttpServletResponse response) throws IOException {
        int width = 110;
        int height = 25;

        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = img.getGraphics();
        g.setColor(Color.PINK);
        g.fillRect(1, 1, width - 2, height - 2);
        g.setColor(Color.RED);
        g.drawRect(0, 0, width - 1, height - 1);
        g.setColor(Color.BLUE);
        g.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 15));

        Random rand = new Random();
        int position = 20;
        for (int i = 0; i < 4; i++) {
            g.drawString(rand.nextInt(10) + "", position, 20);
            position += 20;
        }

        for (int i = 0; i < 9; i++) {
            g.drawLine(rand.nextInt(width), rand.nextInt(height), rand.nextInt(width), rand.nextInt(height));
        }
        ImageIO.write(img, "jpg", response.getOutputStream());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
