package com.tzw.portal.service;

import com.tzw.portal.pojo.Item;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/16.
 */
public interface ItemServicePortal {

    List<Map<String,Object>>  remaiItem();
    List<Map<String,Object>> newItem();
    List<Map<String,Object>> itemMessage(BigInteger tzw_item_id);
}
