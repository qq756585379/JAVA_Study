package com.itcast.jdbcdemo;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Demo2 {

    @Test
    public void test1() throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day01", "root", "123123");

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("select id,name,password,email,birthday from users");

        while (rs.next()) {
            System.out.println(rs.getObject(1));
            System.out.println(rs.getObject(2));
            System.out.println(rs.getObject(3));
            System.out.println(rs.getObject(4));
            System.out.println(rs.getObject(5));
            System.out.println("-----------------");
        }

        rs.close();
        stmt.close();
        conn.close();
    }

    @Test
    public void test2() throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "123123");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day01", info);

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("select id,name,password,email,birthday from users");

        while (rs.next()) {
            System.out.println(rs.getObject(1));
            System.out.println(rs.getObject(2));
            System.out.println(rs.getObject(3));
            System.out.println(rs.getObject(4));
            System.out.println(rs.getObject(5));
            System.out.println("-----------------");
        }

        rs.close();
        stmt.close();
        conn.close();
    }

    @Test
    public void test3() throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day01?user=root&password=root");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select id,name,password,email,birthday from users");

        while (rs.next()) {
            System.out.println(rs.getObject(1));
            System.out.println(rs.getObject(2));
            System.out.println(rs.getObject(3));
            System.out.println(rs.getObject(4));
            System.out.println(rs.getObject(5));
            System.out.println("-----------------");
        }

        rs.close();
        stmt.close();
        conn.close();
    }

    @Test
    public void test4() throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day01?user=root&password=root");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select id,name,password,email,birthday from users");

            while (rs.next()) {
                System.out.println(rs.getObject(1));
                System.out.println(rs.getObject(2));
                System.out.println(rs.getObject(3));
                System.out.println(rs.getObject(4));
                System.out.println(rs.getObject(5));
                System.out.println("-----------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                stmt = null;
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                conn = null;
            }
        }
    }


}
