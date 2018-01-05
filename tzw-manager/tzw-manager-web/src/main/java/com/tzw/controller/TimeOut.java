package com.tzw.controller;

import com.tzw.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/1/5.
 */
@Service("taskCoolJob")
public class TimeOut {

    @Autowired
    private OrderMapper orderMapper;
    /*修改订单状态*/
    public void orderTimeOut()
    {
        System.out.println("5秒执行一次");
         this.orderMapper.updateOrderStatus();
    }
}
