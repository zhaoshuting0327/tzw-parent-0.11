package com.tzw.portal.service.impl;

import com.tzw.portal.mapper.ActiveMapperPortal;
import com.tzw.portal.pojo.NumMid;
import com.tzw.portal.service.ActiveServicePortal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/2/1.
 */
@Service
public class ActiveServiceImplPortal implements ActiveServicePortal {

    @Autowired
    private ActiveMapperPortal activeMapperPortal;

    /**/

    @Override
    public String findNum(BigInteger tzw_item_id) {

        /*获得所有号码*/
        this.activeMapperPortal.findNum(tzw_item_id);

        /*随机抽取*/
        return  "";
    }

    /*每摇一次，向中间表添加数据*/
    @Override
    public void addMid(BigInteger tzw_user_id, BigInteger tzw_item_id, BigInteger tzw_num_id) {

      /*  Map<String,Object> map=new HashMap<>();

        map.put("tzw_user_id",tzw_user_id);
        map.put("tzw_item_id",tzw_item_id);
        map.put("tzw_num_id",tzw_num_id);*/
      NumMid numMid=new NumMid();

      numMid.setTzw_item_id(tzw_item_id);
      numMid.setTzw_user_id(tzw_user_id);
      numMid.setTzw_num_id(tzw_num_id);
        this.activeMapperPortal.addMid(numMid);
    }

    @Override
    public BigInteger findNumById(String tzw_num_content) {
        Map<String,Object> map=new HashMap<>();
        map.put("tzw_num_content",tzw_num_content);
        return this.activeMapperPortal.findNumById(map);
    }

    @Override
    public void clickRig(BigInteger tzw_user_id, BigInteger tzw_num_id, BigInteger tzw_item_id) {

        Map<String,Object> map=new HashMap<>();

        map.put("tzw_user_id",tzw_user_id);
        map.put("tzw_num_id",tzw_num_id);
        map.put("tzw_item_id",tzw_item_id);
        this.activeMapperPortal.clickRig(map);
    }
}
