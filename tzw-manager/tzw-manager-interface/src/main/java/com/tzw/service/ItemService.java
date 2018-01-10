package com.tzw.service;

import com.tzw.pojo.Choujiang;
import com.tzw.pojo.Item;
import com.tzw.pojo.JiFen;
import com.tzw.pojo.JingPai;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Administrator on 2017/12/25.
 */
public interface ItemService {

    List<Item> itemList();

    int peopleNum(BigInteger id);

    List<Item> searchItemList(String lname);

   int  getCount(String lname);

    List<Item> getItemList(Integer cpage, Integer size,String lname);

    void  del(BigInteger tzw_item_id);

    Item findItemById(BigInteger tzw_item_id);

    void  addItem(Item item, JingPai jingpai1, Choujiang choujiang1, JiFen jifen1);

}
