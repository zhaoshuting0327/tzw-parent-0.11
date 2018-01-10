package com.tzw.service.impl;

import com.tzw.mapper.ActiveMapper;
import com.tzw.pojo.Active;
import com.tzw.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
