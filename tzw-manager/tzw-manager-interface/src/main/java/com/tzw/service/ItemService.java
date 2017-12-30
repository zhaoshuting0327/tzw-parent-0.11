package com.tzw.service;

import com.tzw.common.pojo.EasyUIDataGridResult;
import com.tzw.pojo.Item;

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

}
