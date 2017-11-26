package com.itheima.download;

import org.apache.commons.io.FilenameUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        downLoadFile2(request, response);
    }

    private void downLoadFile(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置一个要下载的文件
        String filename = "销售榜单.txt";

        //设置文件名的编码
        if (request.getHeader("user-agent").toLowerCase().contains("msie")) {
            filename = URLEncoder.encode(filename, "UTF-8");//将不安全的文件名改为UTF-8格式
        } else {
            filename = new String(filename.getBytes("UTF-8"), "iso-8859-1");//火狐浏览器
        }
        //告知浏览器要下载文件
        response.setHeader("content-disposition", "attachment;filename=" + filename);
        //response.setHeader("content-type", "image/jpeg");
        response.setContentType(this.getServletContext().getMimeType(filename));//根据文件名自动获得文件类型

        response.setCharacterEncoding("UTF-8");//告知服务器使用什么编码
        //创建一个文件输出流,写入txt中去
        PrintWriter out = response.getWriter();
        out.write("电视机,20\n");
        out.write("洗衣机,10\n");
        out.write("冰箱,8\n");
    }

    private void downLoadFile2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = this.getServletContext().getRealPath("/WEB-INF/images/1.png");

        //告诉浏览器下载图片，不设置的话就是直接显示在浏览器
        //String filename = path.substring(path.lastIndexOf("\\")+1);//找到最后一个/，双/是转义，截取到 美女.jpg
        // filename.substring(path.lastIndexOf(File.separator)+1);
        String filename = FilenameUtils.getName(path);// 效果同上

        filename = URLEncoder.encode(filename, "UTF-8");
        response.setHeader("content-disposition", "attachment;filename=" + filename);
        //response.setHeader("content-type", "image/jpeg");

        int len = 1;
        byte[] b = new byte[1024];

        FileInputStream fis = new FileInputStream(path);//输入流
        ServletOutputStream sos = response.getOutputStream();//输出流

        while ((len = fis.read(b)) != -1) {
            sos.write(b, 0, len);
        }

        sos.close();
        fis.close();
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
