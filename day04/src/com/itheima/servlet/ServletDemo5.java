package com.itheima.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo5 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");

		/*
		 * http://localhost:8080/day04/servlet/demo5
		 */

		/*
		response.setIntHeader("refresh", 1);// 一秒刷新一次
		Random r = new Random();
		response.getWriter().write(r.nextInt()+"");
		*/
		
		response.getWriter().write("注册成功，3秒后跳转主页");
		response.setHeader("refresh", "3;url=/day04/servlet/demo6");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
