package com.itcast.jdbcdemo;

import com.itcast.entity.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Demo3 {

    @Test
    public void testSelect() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day01", "root", "123123");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select password,email,birthday,id,name from users");
        List<User> list = new ArrayList<User>();

        while (rs.next()) {
            User u = new User();
            u.setId(rs.getInt("id"));
            u.setName(rs.getString("name"));
            u.setPassword(rs.getString("password"));
            u.setEmail(rs.getString("email"));
            u.setBirthday(rs.getDate("birthday"));
            list.add(u);
        }
        rs.close();
        stmt.close();
        conn.close();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelect1() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day01", "root", "123123");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select password,email,birthday,id,name from users");
        List<User> list = new ArrayList<User>();


        rs.afterLast();//将光标移动到末尾，正好位于最后一行之后。
        rs.previous();
        rs.beforeFirst();//将光标移动到开头，正好位于第一行之前。
        rs.absolute(2);//参数是当前行的索引，从1开始	根据行的索引定位移动的指定索引行。


        //while(rs.next()){
        User u = new User();
        u.setId(rs.getInt("id"));
        u.setName(rs.getString("name"));
        u.setPassword(rs.getString("password"));
        u.setEmail(rs.getString("email"));
        u.setBirthday(rs.getDate("birthday"));
        list.add(u);
        //}
        rs.close();
        stmt.close();
        conn.close();

        System.out.println(u);
    }

    @Test
    public void testInsert() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day01?user=root&password=root");
        Statement stmt = conn.createStatement();
        int i = stmt.executeUpdate("INSERT INTO users VALUES(4,'tom','123','tom@163.com','2015-09-28')");
        if (i > 0) {
            System.out.println("success");
        }
        stmt.close();
        conn.close();
    }

    @Test
    public void testUpdate() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day01?user=root&password=root");
        Statement stmt = conn.createStatement();
        int i = stmt.executeUpdate("UPDATE users SET NAME='jerry',PASSWORD='333',email='jerry@163.com' WHERE id=3");
        if (i > 0) {
            System.out.println("success" + i);
        } else {
            System.out.println(i);
        }
        stmt.close();
        conn.close();
    }


    @Test
    public void testDelete() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day01?user=root&password=root");
        Statement stmt = conn.createStatement();
        int i = stmt.executeUpdate("DELETE FROM users WHERE id=4");
        if (i > 0) {
            System.out.println("success");
        }
        stmt.close();
        conn.close();
    }

}
