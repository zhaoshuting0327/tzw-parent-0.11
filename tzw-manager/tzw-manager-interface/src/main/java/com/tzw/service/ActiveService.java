package com.tzw.service;

import com.tzw.pojo.Item;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/9.
 */
public interface ActiveService {


    List<Item>loadChouJiang(Integer cpage, Integer size);
    List<Item> loadJiFen(Integer cpage, Integer size);
    List<Item> loadJingPai(Integer cpage, Integer size);

    int chouJiangCount();
    int jiFenCount();
    int jingPaiCount();
}
