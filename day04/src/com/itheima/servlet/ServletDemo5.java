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
		/*response.setIntHeader("refresh", 1);//����1����ˢ��һ��
		
		Random r = new Random();
		
		response.getWriter().write(r.nextInt()+"");*/
		
		response.getWriter().write("ע��ɹ���3����������ҳ");
		//����3������ת
		response.setHeader("refresh", "3;url=/day09_00_HttpServletResponse/servlet/demo6");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
