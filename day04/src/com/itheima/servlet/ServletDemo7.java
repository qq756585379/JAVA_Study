package com.itheima.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo7 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("A:我要借钱！");
		System.out.println("B:我不有，但是我可以告诉你谁有");
		/*//告诉客户端要重新定向新的资源
		response.setStatus(302);
		//告诉浏览器要去访问哪个URL
		response.setHeader("location", "/day09_00_HttpServletResponse/servlet/demo8");*/
		
		//请求重定向
		response.sendRedirect("/day09_00_HttpServletResponse/servlet/demo8");
		
		System.out.println("A: 我去了");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
