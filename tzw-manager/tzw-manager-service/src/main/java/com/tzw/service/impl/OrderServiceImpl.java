package com.tzw.service.impl;

import com.tzw.common.utils.OrderUtil;
import com.tzw.mapper.OrderMapper;
import com.tzw.pojo.Order;
import com.tzw.pojo.OrderShipping;
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
                  }

        int total=this.orderMapper.getOrderCount(map);

        return all;
    }

    /*订单修改回显*/
    @Override
    public Order findOrderById(BigInteger tzw_order_id) {

        //查询order-shipping表

        OrderShipping orderShipping= this.orderMapper.findShippingById(tzw_order_id);

        Order orderById = new Order();

        orderById.setTzw_order_id(tzw_order_id);
        orderById.setTzw_receiver_address(orderShipping.getTzw_receiver_address());
        orderById.setTzw_receiver_phone(orderShipping.getTzw_receiver_phone());

        return orderById;
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



    @Override
    public void updateOrder(Order order) {

        Date date=new Date();

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");

        String updateDate = simpleDateFormat.format(date);

        order.setTzw_order_updateDate(updateDate);

        String tzw_shipping_name = order.getTzw_shipping_name();

        int i = Integer.parseInt(tzw_shipping_name);
        /* <input type="radio" checked="" value="1" id="optionsRadios9" name="tzw_shipping_name">顺丰</label>

                        <label>
                            <input type="radio" value="2" id="optionsRadios10" name="tzw_shipping_name">圆通</label>
                        <label>
                            <input type="radio" value="3" id="optionsRadios11" name="tzw_shipping_name">百世</label>
                        <label>
                            <input type="radio" value="4" id="optionsRadios12" name="tzw_shipping_name">邮政</label>
                        <label>
                            <input type="radio" value="5" id="optionsRadios13" name="tzw_shipping_name">中通</label>
                        <label>
                            <input type="radio" value="6" id="optionsRadios14" name="tzw_shipping_name">韵达</label>
                        <label>
                            <input type="radio" value="7" id="optionsRadios15" name="tzw_shipping_name">其他</label>*/
        if(i==1)
        {
            order.setTzw_shipping_name("顺丰");
        } else if(i==2)
        {
            order.setTzw_shipping_name("圆通");
        }else if(i==3)
        {
            order.setTzw_shipping_name("百世");
        }else if(i==4)
        {
            order.setTzw_shipping_name("邮政");
        }else if(i==5)
        {
            order.setTzw_shipping_name("中通");
        }else if(i==6)
        {
            order.setTzw_shipping_name("韵达");
        }else if(i==7)
        {
            order.setTzw_shipping_name("其他");
        }


        this.orderMapper.updateOrder(order);



    }

}
