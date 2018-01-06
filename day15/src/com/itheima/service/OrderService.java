package com.itheima.service;

import com.itheima.dao.OrderDao;
import com.itheima.dao.OrderItemDao;
import com.itheima.dao.ProductDao;
import com.itheima.domain.Order;
import com.itheima.exception.OrderException;
import com.itheima.util.ManagerThreadLocal;

import java.sql.SQLException;
import java.util.List;

public class OrderService {

    OrderDao orderDao = new OrderDao();
    OrderItemDao orderItemDao = new OrderItemDao();
    ProductDao productDao = new ProductDao();

    public void addOrder(Order order) {
        try {
            ManagerThreadLocal.startTransacation();
            orderDao.addOrder(order);
            orderItemDao.addOrderItem(order);
            productDao.updateProductNum(order);

            ManagerThreadLocal.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            ManagerThreadLocal.rollback();
        }
    }

    public List<Order> findOrdersByUserId(int id) {
        try {
            return orderDao.findOrders(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Order findOrdersByOrderId(String orderid) {
        try {
            return orderDao.findOrdersByOrderId(orderid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void modifyOrderState(String orderid) throws OrderException {
        try {
            orderDao.modifyOrderState(orderid);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderException("modifyOrderState--error");
        }
    }
}

