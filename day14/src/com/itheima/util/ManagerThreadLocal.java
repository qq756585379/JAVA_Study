package com.itheima.util;

import java.sql.Connection;
import java.sql.SQLException;

public class ManagerThreadLocal {

    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    public static Connection getConnection() {
        Connection conn = tl.get();//从当前现成取出一个连接
        if (conn == null) {
            conn = C3P0Util.getConnection();
            tl.set(conn);//把连接放入当前线程
        }
        return conn;
    }

    public static void startTransacation() {
        try {
            Connection conn = getConnection();
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void commit() {
        try {
            getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollback() {
        try {
            getConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close() {
        try {
            getConnection().close();
            tl.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
