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

 /*   @Override
    public List<Item> searchItemList(String lname) {

        Map<String,Object> map=new HashMap<>();

        map.put("lname",lname);


        return itemMapper.searchItemList(map);
    }*/

    /*
    * easyui分页*/
    @Override
    public EasyUIDataGridResult getItemList(Integer page, Integer rows,String lname) {


        System.out.println(page+"serview============");
        System.out.println(rows+"serview============");
        Map<String,Object> map=new HashMap<>();

        /*
        * 第五页  十条
        *
        map.put("index",(page-1)*rows);

        map.put("rows",rows);

        * */



        map.put("index",(page-1)*rows);
        map.put("rows",rows);

        map.put("lname",lname);



        List<Item> items = this.itemMapper.selectByMap(map);

        System.out.println(items.size()+"列表长度====items.size===");


        for(int i=0;i<items.size();i++)

        {
            //查询购买用户数
            int peopleNum = peopleNum(items.get(i).getTzw_item_id());
            items.get(i).setPeopleNum(peopleNum);
        }


        EasyUIDataGridResult easyUIDataGridResult=new EasyUIDataGridResult();

        easyUIDataGridResult.setRows(items);

        long total = this.itemMapper.getTotal(map);

        easyUIDataGridResult.setTotal(total);



        return easyUIDataGridResult;
    }


}
