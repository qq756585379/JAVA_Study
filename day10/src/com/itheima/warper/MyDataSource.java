package com.itheima.warper;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

import com.itheima.util.DBUtils;

public class MyDataSource implements DataSource {

    private static LinkedList<Connection> pool = (LinkedList<Connection>) Collections.synchronizedList(new LinkedList<Connection>());

    static {
        try {
            for (int i = 0; i < 10; i++) {
                Connection conn = DBUtils.getConnection();
                pool.add(conn);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("xxxxxxxxxx");
        }
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        if (pool.size() > 0) {
            conn = pool.removeFirst();
            //包装 Connection
            MyConnection myConn = new MyConnection(conn, pool);
            return myConn;
        } else {
            throw new RuntimeException("服务器繁忙！！！");
        }
    }

    public Connection getConnection(String username, String password)
            throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    public PrintWriter getLogWriter() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    public void setLogWriter(PrintWriter out) throws SQLException {
        // TODO Auto-generated method stub
    }

    public void setLoginTimeout(int seconds) throws SQLException {
        // TODO Auto-generated method stub
    }

    public int getLoginTimeout() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }
}
