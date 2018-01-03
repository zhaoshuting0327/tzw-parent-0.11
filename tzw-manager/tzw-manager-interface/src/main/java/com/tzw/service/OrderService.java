package com.tzw.service;

import com.tzw.pojo.Order;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/28.
 */
public interface OrderService {


    List<Order> findAllOrder1(String lname,int page,int rows);


    Order findOrderById(BigInteger id);

    void updateOrder(Order order);

    void deleteOrder(BigInteger id);

    int getOrderCount(String lname);
}
