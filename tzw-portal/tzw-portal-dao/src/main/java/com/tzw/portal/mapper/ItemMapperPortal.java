package com.tzw.portal.mapper;


import com.tzw.portal.pojo.Item;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/25.
 */
public interface ItemMapperPortal {

    List<Map<String,Object>>  remaiItem();
    List<Map<String,Object>> newItem();
    List<Map<String,Object>> itemMessage(BigInteger tzw_item_id);
}
