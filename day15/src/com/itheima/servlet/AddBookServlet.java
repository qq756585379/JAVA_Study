package com.itheima.web.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.domain.Book;
import com.itheima.service.BookServiceImpl;
import com.itheima.util.UUIDUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

public class AddBookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");//优先级不高
        // 要执行文件上传的操作
        // 判断表单是否支持文件上传。即：enctype="multipart/form-data"
        boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
        if (!isMultipartContent) {
            throw new RuntimeException("your form is not multipart/form-data");
        }

        //创建一个DiskFileItemFactory工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();

        String directoryRealPath = this.getServletContext().getRealPath("/temp");
        File tempDirectory = new File(directoryRealPath);// 即代表文件又代表目录
        if (!tempDirectory.exists()) {
            tempDirectory.mkdirs();// 创建一个指定的目录
        }

        factory.setRepository(new File(directoryRealPath));// 指定临时文件的存储目录

        //创建一个ServletFileUpload对象
        ServletFileUpload sfu = new ServletFileUpload(factory);
        sfu.setHeaderEncoding("UTF-8");//解决上传文件的乱码
        sfu.setFileSizeMax(1024 * 1024 * 10);//表示10M大小
        sfu.setSizeMax(1024 * 1024 * 10);

        //解析request对象，返回所有表单项
        List<FileItem> fileItems = new ArrayList<FileItem>(0);
        //用于封装普通表单项的数据
        Map<String, String[]> map = new HashMap<String, String[]>();

        try {
            fileItems = sfu.parseRequest(request);

            //迭代fileItems表单项
            for (FileItem fileItem : fileItems) {

                if (fileItem.isFormField()) {
                    //普通表单项
                    String name = fileItem.getFieldName();//得到字段的名
                    String value = fileItem.getString("UTF-8");//得到字段值
                    //value = new String(value.getBytes("iso-8859-1"), "utf-8");
                    System.out.println("***" + name + " = " + value);
                    map.put(name, new String[]{value});//向map中赋值
                } else {
                    //文件表单项
                    //得到文件输入流
                    InputStream inputStream = fileItem.getInputStream();
                    String filename = fileItem.getName();//得到上传的文件名
                    String extension = FilenameUtils.getExtension(filename);

                    if (!("jsp".equals(extension) || "exe".equals(extension))) {//上传的文件不能是jsp、exe
                        //创建目录
                        File storeDirectory = new File(this.getServletContext().getRealPath("/upload"));
                        if (!storeDirectory.exists()) {
                            storeDirectory.mkdirs();//如何目录不存在，就创建
                        }

                        //处理文件名
                        if (filename != null) {
                            // filename.substring(filename.lastIndexOf(File.separator)+1);
                            filename = FilenameUtils.getName(filename);// 效果同上
                        }

                        // 目录打散
                        String childDirectory = makeChildDirectory(storeDirectory, filename); // a/b
                        // 解决文件同名的问题
                        filename = childDirectory + File.separator + UUID.randomUUID() + "_" + filename;
                        //文件上传
                        fileItem.write(new File(storeDirectory, filename));
                        fileItem.delete();    //删除临时文件
                    }
                    map.put(fileItem.getFieldName(), new String[]{filename});//将图片表单项的name和value保存到map中
                }
            }

            Book book = new Book();
            BeanUtils.populate(book, map);
            book.setId(UUIDUtil.getUUID());//设置图书编号

            //调用业务逻辑
            BookServiceImpl bs = new BookServiceImpl();
            bs.addBook(book);

            //分发转向
            //不写/代表相对路径，相对于本类的路径
            request.getRequestDispatcher("bookListServlet").forward(request, response);

        } catch (FileUploadBase.FileSizeLimitExceededException e) {
            System.out.println("文件过大，不能超过10M");
            throw new RuntimeException("文件过在，不能超过10M");
        } catch (FileUploadBase.SizeLimitExceededException e) {
            System.out.println("总文件大小不能超过10M");
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

		/*

        //获取表单数据
		Book book = new Book();
		try {
			BeanUtils.populate(book, request.getParameterMap());
			book.setId(UUIDUtil.getUUID());//手动生成一个随机ID
		} catch (Exception e) {
			e.printStackTrace();
		}
		//调用业务逻辑
		BookServiceImpl bs = new BookServiceImpl();
		bs.addBook(book);

		//分发转向
		//不写/代表相对路径，相对于本类的路径
		request.getRequestDispatcher("bookListServlet").forward(request, response);

		*/
    }

    // 目录打散
    private String makeChildDirectory(File storeDirectory, String filename) {
        int hashcode = filename.hashCode();// 返回字符转换的32位hashcode码
        System.out.println(hashcode);
        String code = Integer.toHexString(hashcode); // 把hashcode转换为16进制的字符
        // abdsaf2131safsd
        System.out.println(code);
        String childDirectory = code.charAt(0) + File.separator + code.charAt(1); // a/b
        // 创建指定目录
        File file = new File(storeDirectory, childDirectory);
        if (!file.exists()) {
            file.mkdirs();
        }
        return childDirectory;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
