package com.itheima.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo7 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("A:��Ҫ��Ǯ��");
		System.out.println("B:�Ҳ��У������ҿ��Ը�����˭��");
		/*//���߿ͻ���Ҫ���¶����µ���Դ
		response.setStatus(302);
		//���������Ҫȥ�����ĸ�URL
		response.setHeader("location", "/day09_00_HttpServletResponse/servlet/demo8");*/
		
		//�����ض���
		response.sendRedirect("/day09_00_HttpServletResponse/servlet/demo8");
		
		System.out.println("A: ��ȥ��");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
