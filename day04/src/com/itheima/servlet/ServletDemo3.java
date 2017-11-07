package com.itheima.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = this.getServletContext().getRealPath("/WEB-INF/classes/美女.jpg");

		//告诉浏览器下载图片，不设置的话就是直接显示在浏览器
//		String filename = path.substring(path.lastIndexOf("\\")+1);//找到最后一个/，双/是转义，截取到 美女.jpg
//		filename = URLEncoder.encode(filename, "UTF-8");
//		response.setHeader("content-disposition", "attachment;filename="+filename);
//		response.setHeader("content-type", "image/jpeg");
		
		int len = 1;
		byte[] b = new byte[1024];

		FileInputStream fis = new FileInputStream(path);//输入流
		ServletOutputStream sos = response.getOutputStream();//输出流

		while((len=fis.read(b))!=-1){
			sos.write(b,0,len);
		}
		
		sos.close();
		fis.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
