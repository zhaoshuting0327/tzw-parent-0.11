package com.tzw.service.impl;

import com.tzw.common.pojo.EasyUIDataGridResult;
import com.tzw.mapper.ItemMapper;
import com.tzw.pojo.Item;
import com.tzw.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/25.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;
    @Override
    public List<Item> itemList() {

        List<Item> items = this.itemMapper.itemList();

        for(int i=0;i<items.size();i++)

        {
            //查询购买用户数
            int peopleNum = peopleNum(items.get(i).getTzw_item_id());
            items.get(i).setPeopleNum(peopleNum);
        }


        return items;
    }

    @Override
    public int peopleNum(BigInteger id) {
        return this.itemMapper.peopleNum(id);
    }

    @Override
    public List<Item> searchItemList(String lname) {
        return null;
    }

    @Override
    public int getCount(String lname) {

        Map<String,Object> map=new HashMap<>();
        map.put("lname",lname);
        return this.itemMapper.getTotal(map);
    }

    @Override
    public  List<Item> getItemList(Integer cpage, Integer size,String lname) {

        Map<String,Object> map=new HashMap<>();

        map.put("cpage",(cpage-1)*size);
        map.put("size",size);

        map.put("lname",lname);



        List<Item> items = this.itemMapper.selectByMap(map);

        for(int i=0;i<items.size();i++)
        {
            //查询购买用户数
            int peopleNum = peopleNum(items.get(i).getTzw_item_id());
            items.get(i).setPeopleNum(peopleNum);

            //1下架  2未下架
            if ( items.get(i).getTzw_item_status()==1)
            {
                items.get(i).setTzw_item_status1("下架");
            }else {
                items.get(i).setTzw_item_status1("未下架");
            }



        }
        return items;
    }
    @Override
    public void del(BigInteger tzw_item_id) {
        this.itemMapper.del(tzw_item_id);
    }

    @Override
    public Item findItemById(BigInteger tzw_item_id) {

        Item itemById = this.itemMapper.findItemById(tzw_item_id);

        return itemById;
    }


}
