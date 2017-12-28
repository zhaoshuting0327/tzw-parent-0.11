package com.tzw.controller;

import com.tzw.common.pojo.EasyUIDataGridResult;
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
import java.util.List;

/**
 * Created by Administrator on 2017/12/25.
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("item_listJson")
    @ResponseBody
    public List<Item>  item_list(HttpServletRequest request, HttpSession httpSession, @RequestParam(name="pageNum",defaultValue = "1")  Integer pageNum,
                                               @RequestParam(name="pageSize",defaultValue = "10")  Integer pageSize,Model model) {

        String lname = request.getParameter("lname");

        if (lname!=null||!"".equals(lname))
        {
            System.out.println(lname);
            httpSession.setAttribute("lname",lname);
        }

        lname= (String) httpSession.getAttribute("lname");

        List<Item> itemList = this.itemService.itemList();
        EasyUIDataGridResult result = itemService.getItemList(pageNum, pageSize,lname);

        model.addAttribute("list",result.getRows());
        System.out.println(result.getRows().size()+"列表长度=======");
        for (int i=0;i<result.getRows().size();i++)
        {
            Item o = (Item) result.getRows().get(i);
            System.out.println(o.getTzw_item_createDate()+"==");
            System.out.println(o.getTzw_item_updateDate()+"==");
            String s = o.getTzw_item_createDate() + "";
            String s1 = o.getTzw_item_updateDate() + "";

            o.setTzw_item_createDate(s.substring(0,s.length()-2));
            o.setTzw_item_updateDate(s1.substring(0,s1.length()-2));
        }
        return  result.getRows();

    }
/*    string s = "ABDCETDSA";
    string str = s.Remove(s.Length-4,s.Length);
    string str = s.Substring(0,s.Length-4); */
    @RequestMapping("item_list")
    public String item()
    {
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
