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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/28.
 */
@Controller
public class OrderController {

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
        m.put("cpage", cpage);
        m.put("epage", epage);
        m.put("total", total);

        model.addAttribute("total",total);
        System.out.println(total+"total+==================");
        return m;
    }


}
