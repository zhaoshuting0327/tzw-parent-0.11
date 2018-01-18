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

            //1下架  2未下架
            if ( items.get(i).getTzw_item_status()==1)
            {
                items.get(i).setTzw_item_status1("上架");
            }else {
                items.get(i).setTzw_item_status1("不上架");
            }

            if ( items.get(i).getTzw_item_choujiang()==3)
            {
                items.get(i).setTzw_item_choujiang1("是");
            }else {
                items.get(i).setTzw_item_choujiang1("不是");
            }

            if ( items.get(i).getTzw_item_jifen()==5)
            {
            items.get(i).setTzw_item_jifen1("是");
            }else {
            items.get(i).setTzw_item_jifen1("不是");
            }

            if ( items.get(i).getTzw_item_jingpai()==7)
            {
                items.get(i).setTzw_item_jingpai1("是");
            }else {
                items.get(i).setTzw_item_jingpai1("不是");
            }
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
            if ( items.get(i).getTzw_item_choujiang()==3)
            {
                items.get(i).setTzw_item_choujiang1("是");
            }else {
                items.get(i).setTzw_item_choujiang1("不是");
            }
            if ( items.get(i).getTzw_item_jifen()==5)
            {
                items.get(i).setTzw_item_jifen1("是");
            }else {
                items.get(i).setTzw_item_jifen1("不是");
            }
            if ( items.get(i).getTzw_item_jingpai()==7)
            {
                items.get(i).setTzw_item_jingpai1("是");
            }else {
                items.get(i).setTzw_item_jingpai1("不是");
            }

            if ( items.get(i).getTzw_item_type()==9)
            {
                items.get(i).setTzw_item_type1("翡翠");
            }
            else  if(items.get(i).getTzw_item_type()==10)
            {
                items.get(i).setTzw_item_type1("珍珠");
            }
              else  if(items.get(i).getTzw_item_type()==11)
            {
                items.get(i).setTzw_item_type1("彩宝");
            }
              else  if(items.get(i).getTzw_item_type()==12)
            {
                items.get(i).setTzw_item_type1("文玩");
            }
              else  if(items.get(i).getTzw_item_type()==13)
            {
                items.get(i).setTzw_item_type1("生活用品");
            }


            if ( items.get(i).getTzw_item_leibie()==14)
            {
                items.get(i).setTzw_item_leibie1("热卖商品");
            }
            else  if(items.get(i).getTzw_item_leibie()==15)
            {
                items.get(i).setTzw_item_leibie1("新品");
            }
            else  if(items.get(i).getTzw_item_leibie()==16)
            {
                items.get(i).setTzw_item_leibie1("其他");
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
        System.out.println("添加service1");
        this.itemMapper.addItem(item);

        System.out.println("tzw_item_content:::"+item.getTzw_item_content());
        System.out.println("添加service2");


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

            System.out.println("流拍："+jingpai1.getTzw_jingpai_liupai());
            this.itemMapper.addJingPai(jingpai1);

        }
    }

    //修改提交
    @Override
    public void updateById(Item item, Choujiang choujiang1, JiFen jifen1, JingPai jingpai1) {

        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String updateDate = simpleDateFormat.format(date);
        //返回id值
        item.setTzw_item_updateDate(updateDate);

        Item itemById = this.itemMapper.findItemById(item.getTzw_item_id());
        //抽奖商品修改
        if(item.getTzw_item_choujiang()==3&&itemById.getTzw_item_choujiang()==4)
        {
            //将信息填入抽奖表
            Choujiang choujiang=new Choujiang();
            choujiang.setTzw_choujiang_preNum(item.getTzw_choujiang_preNum());
            choujiang.setTzw_choujiang_houNum(item.getTzw_choujiang_houNum());
            choujiang.setTzw_choujiang_item_id(item.getTzw_item_id());
            choujiang.setTzw_choujiang_createDate(updateDate);

            choujiang.setTzw_choujiang_jifen(choujiang1.getTzw_choujiang_jifen());
            choujiang.setTzw_choujiang_xianjin(choujiang1.getTzw_choujiang_xianjin());
            choujiang.setTzw_choujiang_yue(choujiang1.getTzw_choujiang_yue());
            this.itemMapper.addChouJiang(choujiang);
        }else {
            //如果抽奖表存在，从抽奖表里边删除 取消为抽奖商品
            this.itemMapper.delChoujiang(item.getTzw_item_id());
        }

         if(item.getTzw_item_jifen()==5&&itemById.getTzw_item_jifen()==6)
         {
             //将信息填入积分表
             JiFen jiFen=new JiFen();

             jiFen.setTzw_jifen_createDate(updateDate);
             jiFen.setTzw_jifen_num(item.getTzw_jifen_num());
             jiFen.setTzw_jifen_item_id(item.getTzw_item_id());

             jiFen.setTzw_jifen_yue(jifen1.getTzw_jifen_yue());
             jiFen.setTzw_jifen_xianjin(jifen1.getTzw_jifen_xianjin());
             this.itemMapper.addJiFen(jiFen);
         }
         else {
            this.itemMapper.delJiFen(item.getTzw_item_id());
         }

         if(item.getTzw_item_jingpai()==7&&itemById.getTzw_item_jingpai()==8)
         {
             JingPai jingPai = new JingPai();

             jingPai.setTzw_jingpai_createDate(updateDate);
             jingPai.setTzw_jingpai_item_id(item.getTzw_item_id());
             jingPai.setTzw_jingpai_num(item.getTzw_jingpai_num());

             jingPai.setTzw_jingpai_yue(jingpai1.getTzw_jingpai_yue());
             jingPai.setTzw_jingpai_jifen(jingpai1.getTzw_jingpai_jifen());
             jingPai.setTzw_jingpai_xianjin(jingpai1.getTzw_jingpai_xianjin());
             jingPai.setTzw_jingpai_liupai(jingpai1.getTzw_jingpai_liupai());
             this.itemMapper.addJingPai(jingPai);
         }
        this.itemMapper.updateById(item);
    }


}
