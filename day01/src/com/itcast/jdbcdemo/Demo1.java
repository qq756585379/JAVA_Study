package com.itcast.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {

    public static void main(String[] args) throws Exception {

        //1、注册驱动---不建议使用
        //解决办法： Class.forName("com.mysql.jdbc.Driver");

        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //2、创建连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day01", "root", "123123");
        //3、得到执行sql语句的Statement对象
        Statement stmt = conn.createStatement();
        //4、执行sql语句，并返回结果
        ResultSet rs = stmt.executeQuery("select password,email,birthday,id,name from users");
        //5、处理结果
        while (rs.next()) {
            System.out.println(rs.getObject("id"));
            System.out.println(rs.getObject("name"));
            System.out.println(rs.getObject("password"));
            System.out.println(rs.getObject("birthday"));
            System.out.println(rs.getObject("email"));
            System.out.println("-----------------");
        }
        //6、关闭资源
        rs.close();
        stmt.close();
        conn.close();

    }

}
