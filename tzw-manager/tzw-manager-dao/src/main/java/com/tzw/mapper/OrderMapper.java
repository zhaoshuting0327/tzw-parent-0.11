package com.tzw.mapper;

import com.tzw.pojo.Order;
import com.tzw.pojo.OrderShipping;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/28.
 */
public interface OrderMapper {


    List<Order> findAllOrder1(Map<String,Object> map);

    Order findOrderById(BigInteger id);

    void updateOrder(Order order);

    void deleteOrder(BigInteger id);

    int getOrderCount(Map<String,Object> map);

    void delById(BigInteger tzw_order_id);

    void updateOrderStatus();

    OrderShipping findShippingById(BigInteger tzw_order_id);


}
