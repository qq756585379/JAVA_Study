package com.itheima.dao;

import com.itheima.domain.Order;
import com.itheima.domain.OrderItem;
import com.itheima.util.ManagerThreadLocal;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;
import java.util.List;

public class OrderItemDao {
    //添加定单项
    public void addOrderItem(Order order) throws SQLException {
        List<OrderItem> orderItems = order.getOrderItems();//得到所有定单项的集合
        QueryRunner qr = new QueryRunner();
        Object[][] params = new Object[orderItems.size()][];

        for (int i = 0; i < params.length; i++) {
            //数组中的第一个参数代表主单id， 第二个参数：商品id 第三个参数 ：商品的购买数量
            params[i] = new Object[]{order.getId(), orderItems.get(i).getP().getId(), orderItems.get(i).getBuynum()};
        }
        qr.batch(ManagerThreadLocal.getConnection(), "INSERT INTO orderitem VALUES(?,?,?)", params);
    }
}
