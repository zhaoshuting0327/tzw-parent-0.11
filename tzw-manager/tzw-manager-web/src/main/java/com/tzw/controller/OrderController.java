package com.tzw.controller;

import com.tzw.pojo.Order;
import com.tzw.pojo.User;
import com.tzw.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017/12/28.
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    /*user列表展示*/

    @RequestMapping("order_list")
    public String order_list()
    {
        return "order_list";
    }

    @RequestMapping("order_listJson")
    @ResponseBody
    public List<Order> user_listJson(HttpServletRequest request, HttpSession httpSession, @RequestParam(name="pageNum",defaultValue = "1")  Integer pageNum,
                                @RequestParam(name="pageSize",defaultValue = "10")  Integer pageSize, Model model)
    {
        String lname = request.getParameter("lname");

        if (lname!=null||!"".equals(lname))
        {
            System.out.println(lname);
            httpSession.setAttribute("lname",lname);
        }

        lname= (String) httpSession.getAttribute("lname");

        List<Order> orderList = this.orderService.findAllOrder1(lname,pageNum,pageSize);

        return orderList;
    }


}
