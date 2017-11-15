package com.itheima.pool;

import java.sql.Connection;
import java.util.Collections;
import java.util.LinkedList;

import com.itheima.util.DBUtils;

//模拟连接池，无实际开发意义
public class SimpleConnectionPool {
    private static LinkedList<Connection> pool = (LinkedList<Connection>) Collections.synchronizedList(new LinkedList<Connection>());

    static {
        try {
            for (int i = 0; i < 10; i++) {
                Connection conn = DBUtils.getConnection();
                pool.add(conn);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("11111111111111");
        }
    }

    public static Connection getConnectionFromPool() {
        Connection conn = null;
        if (pool.size() > 0) {
            conn = pool.removeFirst();
            return conn;
        } else {
            throw new RuntimeException("服务器忙！！");
        }

    }

    public static void release(Connection conn) {
        pool.addLast(conn);
    }
}
