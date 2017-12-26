package com.tzw.controller;

import com.tzw.common.pojo.EasyUIDataGridResult;
import com.tzw.pojo.Item;
import com.tzw.pojo.User;
import com.tzw.service.ItemService;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017/12/25.
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/itemList")
    public String ItemList(Model model) {
        List<Item> itemList = this.itemService.itemList();
        model.addAttribute("itemList",itemList);
        System.out.println(itemList.size());
        return "item-list";
    }

    @RequestMapping("/item/itemListjson")
    @ResponseBody
    public EasyUIDataGridResult ItemListjson(Integer page, Integer rows) {
        List<Item> itemList = this.itemService.itemList();
        EasyUIDataGridResult result = itemService.getItemList(page, rows);
        return result;
    }

     /*
         controller
          @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
        //调用服务查询商品列表
        EasyUIDataGridResult result = itemService.getItemList(page, rows);
        return result;
    }*/
    /*int page,int rows*/

/*
   /item/search
*/

    @RequestMapping("/item/search")
    public String searchItemList(String lname, HttpSession httpSession, Model model) {


        List<Item> itemList = this.itemService.searchItemList(lname);
        model.addAttribute("itemList",itemList);
        System.out.println(itemList.size());

        if (lname!=null||!"".equals(lname))
        {
            httpSession.setAttribute("lname",lname);
        }

       lname= (String) httpSession.getAttribute("lname");


/*
         service

         @Override
    public EasyUIDataGridResult getItemList(int page, int rows) {
        //设置分页信息
        PageHelper.startPage(page, rows);
        //执行查询
        TbItemExample example = new TbItemExample();
        List<TbItem> list = itemMapper.selectByExample(example);
        //创建一个返回值对象
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setRows(list);
        //取分页结果
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        //取总记录数
        long total = pageInfo.getTotal();
        result.setTotal(total);
        return result;
    }
    }




*/
        return "redirect:/item/itemList";
    }
}
