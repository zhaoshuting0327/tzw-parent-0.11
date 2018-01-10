package com.tzw.service.impl;

import com.tzw.mapper.ItemMapper;
import com.tzw.pojo.Choujiang;
import com.tzw.pojo.Item;
import com.tzw.pojo.JiFen;
import com.tzw.pojo.JingPai;
import com.tzw.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
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
                items.get(i).setTzw_item_status1("上架");
            }else {
                items.get(i).setTzw_item_status1("不上架");
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

    @Override
    public void addItem(Item item, JingPai jingpai1, Choujiang choujiang1, JiFen jifen1) {

        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String createDate = simpleDateFormat.format(date);
        //返回id值
        item.setTzw_item_createDate(createDate);
        System.out.println("添加service");
        this.itemMapper.addItem(item);

        /*查询id*/
        HashMap<String,Object> map=new HashMap<>();
        map.put("tzw_item_name",item.getTzw_item_name());
        map.put("tzw_item_num",item.getTzw_item_num());
        map.put("tzw_item_price",item.getTzw_item_price());
      Item item1=  this.itemMapper.findItemByName(map);

       BigInteger bigInteger= item1.getTzw_item_id();



        //判断是否为抽奖商品
        if(item.getTzw_item_choujiang()==3)
        {
            //添加进抽奖表
            choujiang1.setTzw_choujiang_createDate(createDate);
            choujiang1.setTzw_choujiang_item_id(bigInteger);
            this.itemMapper.addChouJiang(choujiang1);
        }
        //判断是否为积分商品
        if(item.getTzw_item_jifen()==5)
        {
            //添加进积分表
            jifen1.setTzw_jifen_createDate(createDate);
            jifen1.setTzw_jifen_item_id(bigInteger);
            this.itemMapper.addJiFen(jifen1);
        }
        //判断是否为竞拍商品
        if(item.getTzw_item_jingpai()==7)
        {
            //添加进竞拍表
            jingpai1.setTzw_jingpai_createDate(createDate);
            jingpai1.setTzw_jingpai_item_id(bigInteger);
            this.itemMapper.addJingPai(jingpai1);

        }
    }


}
