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
    public List<Order> findAllOrder1(String lname, int cpage, int size) {

        Map<String,Object> map=new HashMap<>();

        map.put("lname",lname);
        map.put("cpage",(cpage-1)*size);
        map.put("size",size);

        List<Order> all = this.orderMapper.findAllOrder1(map);

        for (int i=0;i<all.size();i++)
        {
            Order o=all.get(i);

            if(o.getTzw_order_status()==1)
            {
                o.setTzw_order_status1("未付款");
            }else if(o.getTzw_order_status()==2)
            {
                o.setTzw_order_status1("已付款");
            }else if(o.getTzw_order_status()==3)
            {
                o.setTzw_order_status1("未发货");
            }else if(o.getTzw_order_status()==4)
            {
                o.setTzw_order_status1("已发货");
            }else if(o.getTzw_order_status()==5)
            {
                o.setTzw_order_status1("交易成功");
            }else if(o.getTzw_order_status()==6)
            {
                o.setTzw_order_status1("交易关闭");
            }
            /*
        /*                  <td>{{s.tzw_order_id}}</td>
                            <td>{{s.tzw_user_username}}</td>
                            <td>{{s.tzw_item_name}}</td>
                            <td>{{s.tzw_item_num}}</td>
                            <td>{{s.tzw_receiver_phone}}</td>
                            <td>{{s.tzw_receiver_address}}</td>
                            <td>{{s.tzw_order_status1}}</td>
                            <td>{{s.tzw_order_createDate}}</td>*/


        }

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

    @Override
    public int getOrderCount(String lname) {

        HashMap<String,Object> map=new HashMap<>();

        map.put("lname",lname);

        return this.orderMapper.getOrderCount(map);
    }

    @Override
    public void delById(BigInteger tzw_order_id) {
        this.orderMapper.delById(tzw_order_id);
    }

}
