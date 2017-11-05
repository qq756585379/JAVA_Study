package com.itcast.ServletConfig;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletConfig extends HttpServlet {

    private ServletConfig config;

	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        String encoding0 = config.getInitParameter("encoding");//获得配置文件信息
//        System.out.println(encoding0);

        String encoding1 = this.getServletConfig().getInitParameter("encoding");
        System.out.println(encoding1);

		String encoding2 = super.getInitParameter("encoding");
        System.out.println(encoding2);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
