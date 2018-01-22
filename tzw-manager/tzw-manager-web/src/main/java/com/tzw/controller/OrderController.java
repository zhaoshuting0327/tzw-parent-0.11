package com.tzw.controller;

import com.tzw.common.utils.Fenye;
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
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/28.
 */
@Controller
public class OrderController {

    /*
    * 1.过期订单：可在［交易通知］中设置拍下未付款，xx分钟便会关闭订单；
    * 2. 在线退款或标记退款：卖家后台退款后，订单会同步到关闭订单列表中；
    * 3. 被取消订单：未付款订单被卖家或买家在后台取消后，便成为关闭订单；
    *
    * */
    @Autowired
    private OrderService orderService;

    @RequestMapping("order_list")
    public String order_list()
    {
        return "order_list";
    }

    @RequestMapping("order_listJson")
    @ResponseBody
    public HashMap<String,Object> user_listJson(HttpServletRequest request, HttpSession httpSession,Model model)
    {
        String lname = request.getParameter("lname");

        if (lname!=null||!"".equals(lname))
        {
            System.out.println(lname);
            httpSession.setAttribute("lname",lname);
        }

        lname= (String) httpSession.getAttribute("lname");

        String cpage = request.getParameter("cpage");
        int size = 10;
        Fenye fenye = new Fenye();
        int total=this.orderService.getOrderCount(lname);
        Map<String, Object> fen = fenye.Fenye(request, cpage, size,total);
        String cpages = (String) fen.get("cpage");
        Integer epage =  (Integer) fen.get("epage");
        List<Order> list = this.orderService.findAllOrder1(lname,Integer.parseInt(cpages),size);

        HashMap<String,Object> m=new HashMap<>();
        m.put("list", list);
        m.put("cpage", cpages);
        m.put("epage", epage);

        int page=0;
        if(total%10==0)
        {
            page=total/10;
        }else
        {
            page=total/10+1;
        }


        m.put("total", page);
        m.put("totalnum", total);
        return m;
    }

    //订单删除

    @RequestMapping("order/del")
    @ResponseBody
    public int del(BigInteger tzw_order_id)
    {
        this.orderService.delById(tzw_order_id);
        return 1;
    }
    //订单修改回显
    @RequestMapping("toUpdateOrder")
    public String toUpdateOrder(BigInteger tzw_order_id,Model model)
    {
        model.addAttribute("tzw_order_id", tzw_order_id);
        return "order_update";
    }

    @RequestMapping("huixianOrder")
    @ResponseBody
    public Order huixianOrder(BigInteger tzw_order_id)
    {

        Order orderById = this.orderService.findOrderById(tzw_order_id);
        return orderById;
    }

    @RequestMapping("order_update_commit")
    @ResponseBody
    public int order_update_commit(HttpServletRequest request) {

        String tzw_order_id = request.getParameter("tzw_order_id");
        String tzw_shipping_code = request.getParameter("tzw_shipping_code");
        String tzw_shipping_name = request.getParameter("tzw_shipping_name");

        Order order=new Order();

        BigInteger bigInteger=new BigInteger(tzw_order_id);
        order.setTzw_order_id(bigInteger);
        order.setTzw_shipping_code(tzw_shipping_code);
        order.setTzw_shipping_name(tzw_shipping_name);
        this.orderService.updateOrder(order);
        return 1;
    }
}
