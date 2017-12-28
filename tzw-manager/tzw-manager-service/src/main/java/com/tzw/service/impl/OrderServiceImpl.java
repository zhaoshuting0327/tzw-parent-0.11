package com.tzw.service.impl;

import com.tzw.mapper.OrderMapper;
import com.tzw.pojo.Order;
import com.tzw.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/28.
 */
@Service
public class OrderServiceImpl implements OrderService {

  @Autowired
    private OrderMapper orderMapper;


    @Override
    public List<Order> findAllOrder1(String lname, int page, int rows) {

        Map<String,Object> map=new HashMap<>();

        map.put("lname",lname);
        map.put("index",(page-1)*rows);
        map.put("rows",rows);

        List<Order> all = this.orderMapper.findAllOrder1(map);

        int total=this.orderMapper.getOrderCount(map);

        return all;
    }

    @Override
    public Order findOrderById(BigInteger id) {
        return this.orderMapper.findOrderById(id);
    }

    @Override
    public void updateOrder(Order order) {

        Date date=new Date();

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");

        String format = simpleDateFormat.format(date);


        order.setTzw_order_updateDate(format);
        this.orderMapper.updateOrder(order);
    }

    @Override
    public void deleteOrder(BigInteger id) {

        this.orderMapper.deleteOrder(id);
    }

}
