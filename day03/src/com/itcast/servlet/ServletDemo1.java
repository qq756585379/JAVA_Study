package com.itcast.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo1 implements Servlet{

	//实例化，会先调这个方法
	public ServletDemo1(){
		System.out.println("1.***********ServletDemo1ִ*********");
	}

	//初始化
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("2.***********initִ*********");
		
	}

	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("hello servlet");
		System.out.println("***********serviceִ*********");
	}

	public void destroy() {
		System.out.println("***********destroyִ*********");
	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return null;
	}
	
}
