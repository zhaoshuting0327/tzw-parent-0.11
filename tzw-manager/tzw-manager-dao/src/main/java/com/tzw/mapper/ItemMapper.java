package com.tzw.mapper;

import com.tzw.pojo.Choujiang;
import com.tzw.pojo.Item;
import com.tzw.pojo.JiFen;
import com.tzw.pojo.JingPai;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/25.
 */
public interface ItemMapper {

    List<Item> itemList();

    List<Item> selectByMap(Map<String,Object> map);

    int  peopleNum(BigInteger id);

//    List<Item> searchItemList(Map<String, Object> map);

     int getTotal(Map<String,Object> map);

     void  del(BigInteger tzw_item_id);

     Item findItemById(BigInteger tzw_item_id);

    void  addItem(Item item);

   void addChouJiang(Choujiang choujiang);
   void addJiFen(JiFen jiFen);
   void addJingPai(JingPai jingPai);

   // this.itemMapper.findItemByName(item.getTzw_item_name(),item.getTzw_item_num(),item.getTzw_item_price());

   Item findItemByName(HashMap<String,Object> map);
}
