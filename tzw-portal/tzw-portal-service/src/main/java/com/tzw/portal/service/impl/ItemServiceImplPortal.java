package com.tzw.portal.service.impl;

import com.tzw.portal.mapper.ItemMapperPortal;
import com.tzw.portal.pojo.Item;
import com.tzw.portal.service.ItemServicePortal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/16.
 */
@Service
public class ItemServiceImplPortal implements ItemServicePortal {

    @Autowired
    private ItemMapperPortal itemMapperPortal;


    @Override
    public  List<Map<String,Object>>  remaiItem() {

        List<Map<String,Object>>  items = this.itemMapperPortal.remaiItem();

        for (Map<String, Object> m : items) {
            if(Integer.parseInt(m.get("tzw_item_choujiang").toString())==3)
            {
                m.put("tzw_item_activeType","抽奖商品");
            }
            if(Integer.parseInt( m.get("tzw_item_jifen").toString())==5)
            {
                m.put("tzw_item_activeType","积分商品");
            }
            if( Integer.parseInt( m.get("tzw_item_jingpai").toString())==7)
            {
                m.put("tzw_item_activeType","竞拍商品");
            }

            if( Integer.parseInt( m.get("tzw_item_type").toString())==9)
            {
                m.put("tzw_item_itemType","翡翠");
            }    if( Integer.parseInt( m.get("tzw_item_type").toString())==10)
            {
                m.put("tzw_item_itemType","珍珠");
            }    if( Integer.parseInt( m.get("tzw_item_type").toString())==11)
            {
                m.put("tzw_item_itemType","彩宝");
            }    if( Integer.parseInt( m.get("tzw_item_type").toString())==12)
            {
                m.put("tzw_item_itemType","文玩");
            }    if( Integer.parseInt( m.get("tzw_item_type").toString())==13)
            {
                m.put("tzw_item_itemType","生活用品");
            }
        }

        return items;
    }

    @Override
    public  List<Map<String,Object>> newItem() {
        List<Map<String,Object>> items = this.itemMapperPortal.newItem();

        for (Map<String, Object> m : items) {

            if(Integer.parseInt(m.get("tzw_item_choujiang").toString())==3)
            {
                m.put("tzw_item_activeType","抽奖商品");
            }
            if(Integer.parseInt( m.get("tzw_item_jifen").toString())==5)
            {
                m.put("tzw_item_activeType","积分商品");
            }
            if( Integer.parseInt( m.get("tzw_item_jingpai").toString())==7)
            {
                m.put("tzw_item_activeType","竞拍商品");
            }

            if( Integer.parseInt( m.get("tzw_item_type").toString())==9)
            {
                m.put("tzw_item_itemType","翡翠");
            }    if( Integer.parseInt( m.get("tzw_item_type").toString())==10)
            {
                m.put("tzw_item_itemType","珍珠");
            }    if( Integer.parseInt( m.get("tzw_item_type").toString())==11)
            {
                m.put("tzw_item_itemType","彩宝");
            }    if( Integer.parseInt( m.get("tzw_item_type").toString())==12)
            {
                m.put("tzw_item_itemType","文玩");
            }    if( Integer.parseInt( m.get("tzw_item_type").toString())==13)
            {
                m.put("tzw_item_itemType","生活用品");
            }

        }
        return items;
    }

    @Override
    public  List<Map<String,Object>> itemMessage(BigInteger tzw_item_id) {
        return this.itemMapperPortal.itemMessage(tzw_item_id);
    }
}
