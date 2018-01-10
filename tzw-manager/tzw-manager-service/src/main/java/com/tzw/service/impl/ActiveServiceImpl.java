package com.tzw.service.impl;

import com.tzw.mapper.ActiveMapper;
import com.tzw.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/9.
 */
@Service
public class ActiveServiceImpl implements com.tzw.service.ActiveService{

    @Autowired
    private ActiveMapper activeMapper;

    @Override
    public List<Item> loadChouJiang(Integer cpage, Integer size) {
        Map<String,Object> map=new HashMap<>();

        map.put("cpage",(cpage-1)*size);
        map.put("size",size);
        return this.activeMapper.loadChouJiang(map);
    }

    @Override
    public  List<Item> loadJiFen(Integer cpage, Integer size) {
        Map<String,Object> map=new HashMap<>();

        map.put("cpage",(cpage-1)*size);
        map.put("size",size);
        return this.activeMapper.loadJiFen(map);
    }

    @Override
    public  List<Item> loadJingPai(Integer cpage, Integer size) {
        Map<String,Object> map=new HashMap<>();

        map.put("cpage",(cpage-1)*size);
        map.put("size",size);
        return this.activeMapper.loadJingPai(map);
    }

    @Override
    public int chouJiangCount() {
        return this.activeMapper.chouJiangCount();
    }

    @Override
    public int jiFenCount() {
        return this.activeMapper.jiFenCount();
    }

    @Override
    public int jingPaiCount() {
        return this.activeMapper.jingPaiCount();
    }

    @Override
    public void deleteChouJiang(BigInteger tzw_item_id) {
        //修改item表
        this.activeMapper.upItemChou(tzw_item_id);
        this.activeMapper.deleteChouJiang(tzw_item_id);
    }

    @Override
    public void deleteJiFen(BigInteger tzw_item_id) {
        //修改item表
        this.activeMapper.upItemJi(tzw_item_id);
       this.activeMapper.deleteJiFen(tzw_item_id);
    }

    @Override
    public void deleteJingPai(BigInteger tzw_item_id) {
        //修改item表
        this.activeMapper.upItemJing(tzw_item_id);
        this.activeMapper.deleteJingPai(tzw_item_id);
    }

    @Override
    public Item findcByItemId(BigInteger tzw_item_id) {
        return this.activeMapper.findcByItemId(tzw_item_id);
    }

    @Override
    public Item findjiByItemId(BigInteger tzw_item_id) {
        return this.activeMapper.findjiByItemId(tzw_item_id);
    }

    @Override
    public Item findjByItemId(BigInteger tzw_item_id) {
        return this.activeMapper.findjByItemId(tzw_item_id);
    }

    @Override
    public void updatecByItemId(Choujiang choujiang) {

        Date date=new Date();

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat();

        String tzw_choujiang_updateDate = simpleDateFormat.format(date);

        choujiang.setTzw_choujiang_updateDate(tzw_choujiang_updateDate);

        this.activeMapper.updatecByItemId(choujiang);
    }

    @Override
    public void updatejiByItemId(JiFen jiFen) {

        Date date=new Date();

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat();

        String tzw_jifen_updateDate = simpleDateFormat.format(date);

        jiFen.setTzw_jifen_updateDate(tzw_jifen_updateDate);

        this.activeMapper.updatejiByItemId(jiFen);
    }

    @Override
    public void updatejByItemId(JingPai jingPai) {

        Date date=new Date();

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat();

        String tzw_jingpai_updateDate = simpleDateFormat.format(date);

        jingPai.setTzw_jingpai_updateDate(tzw_jingpai_updateDate);

        this.activeMapper.updatejByItemId(jingPai);
    }
}
