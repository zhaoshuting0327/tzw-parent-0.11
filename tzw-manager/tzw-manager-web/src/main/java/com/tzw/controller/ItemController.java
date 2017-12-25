package com.tzw.controller;

import com.tzw.common.pojo.EasyUIDataGridResult;
import com.tzw.pojo.Item;
import com.tzw.pojo.User;
import com.tzw.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /*int page,int rows*/

    public static void main(String[] args) {
        System.out.println("11111111111111");
    }

}
