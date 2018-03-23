package com.tzw.portal.mapper;


import com.tzw.portal.pojo.Item;
import com.tzw.portal.pojo.Num;
import com.tzw.portal.pojo.NumMid;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/25.
 */
public interface ActiveMapperPortal {

    /*查询所有未被选中的号码 参数为商品id 0 未被选中 1 挂起  2 已被选中*/
    List<NumMid> findNum(BigInteger tzw_item_id);

   /*  用户摇一次 将信息添加进中间表 需要参数用户id 商品id 号码id*/
    void  addMid(NumMid numMid);

    // 用户点击确认 步骤1： 根据号码内容查询号码id 返回id
    BigInteger findNumById(Map<String,Object> map);

     // 用户点击确认 步骤2： 需要用户id  号码id 商品id
     void  clickRig(Map<String,Object> map);
}
