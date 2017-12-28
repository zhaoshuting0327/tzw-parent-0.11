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

  EasyUIDataGridResult getItemList(Integer page, Integer rows,String lname);

}
