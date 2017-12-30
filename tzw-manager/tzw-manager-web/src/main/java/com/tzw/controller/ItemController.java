package com.tzw.controller;

import com.tzw.common.pojo.EasyUIDataGridResult;
import com.tzw.common.utils.Fenye;
import com.tzw.pojo.Item;
import com.tzw.service.ItemService;
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
 * Created by Administrator on 2017/12/25.
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("item_listJson")
    @ResponseBody
    public  HashMap<String, Object>  item_list(HttpServletRequest request, HttpSession httpSession) {

        String lname = request.getParameter("lname");


        lname= (String) httpSession.getAttribute("lname");

        String cpage = request.getParameter("cpage");
        int size = 10;
        Fenye fenye = new Fenye();
        int total=this.itemService.getCount(lname);

        Map<String, Object> fen = fenye.Fenye(request, cpage, size, total);
        String cpages = (String) fen.get("cpage");
        Integer epage =  (Integer) fen.get("epage");

        List<Item> list = this.itemService.getItemList(Integer.parseInt(cpages),size,lname);

        System.out.println("返回list长度："+list.size());



        for (int i=0;i<list.size();i++) {
            Item o = (Item) list.get(i);
            System.out.println(o.getTzw_item_createDate() + "==");
            System.out.println(o.getTzw_item_updateDate() + "==");
            String s = o.getTzw_item_createDate() + "";
            String s1 = o.getTzw_item_updateDate() + "";

            o.setTzw_item_createDate(s.substring(0, s.length() - 2));
            o.setTzw_item_updateDate(s1.substring(0, s1.length() - 2));

        }

            HashMap<String, Object> m = new HashMap<>();
            m.put("list", list);
            m.put("cpage", cpage);
            m.put("epage", epage);
            m.put("total", total);

        return m;
    }
/*    string s = "ABDCETDSA";
    string str = s.Remove(s.Length-4,s.Length);
    string str = s.Substring(0,s.Length-4); */
    @RequestMapping("item_list")
    public String item(HttpServletRequest request,HttpSession httpSession)
    {
        item_list(request,httpSession);

        return "item_list";
    }



    @RequestMapping("item_add")
    public String item_add()
    {
        return "item_add";
    }

    //添加提交  item_add_commit

    @RequestMapping("item_add_commit")
    public String item_add_commit(HttpServletRequest request,Model model)
    {
        String itemname = request.getParameter("itemname");
        String itemprice = request.getParameter("itemprice");
        String itemNum = request.getParameter("itemNum");


        System.out.println(itemname);
        System.out.println(itemprice);
        System.out.println(itemNum);
        model.addAttribute("message","商品添加成功！");

        return "200";
    }
}
