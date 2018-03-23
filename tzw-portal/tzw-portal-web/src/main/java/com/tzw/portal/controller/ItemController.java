package com.tzw.portal.controller;

import com.tzw.portal.pojo.Item;
import com.tzw.portal.service.ItemServicePortal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/16.
 */
@Controller
@RequestMapping(value = "/portal/item")
public class ItemController {

    @Autowired
    private ItemServicePortal itemServicePortal;

    /*热卖商品*/
  /*  @RequestMapping("/remaiItem")
    @ResponseBody
    public List<Item> listItem()
    {
        return this.itemServicePortal.remaiItem();
    }*/

    @RequestMapping("/remaiItem")
    @ResponseBody
    public List<Map<String,Object>>  listItem()
    {
        return this.itemServicePortal.remaiItem();
    }

    @RequestMapping("/huidiao")
    @ResponseBody
    public void huidiao()
    {

    }

    /*商品详情*/
    @RequestMapping(value="/itemMessage",method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String,Object>>  itemMessage(HttpServletRequest httpServletRequest)
    {
        String tzw_item_id = httpServletRequest.getParameter("tzw_item_id");

        System.out.println(tzw_item_id+"=======================id");
        BigInteger bigInteger=new BigInteger(tzw_item_id);
        return this.itemServicePortal.itemMessage(bigInteger);
    }

    /*新品*/
    @RequestMapping("/newItem")
    @ResponseBody
    public List<Map<String,Object>>  newItem()
    {
        return this.itemServicePortal.newItem();
    }



}
