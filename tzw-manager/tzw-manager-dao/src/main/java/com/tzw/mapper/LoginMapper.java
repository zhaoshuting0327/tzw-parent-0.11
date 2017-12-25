package com.tzw.mapper;

import com.tzw.pojo.Owner;

import java.util.Map;

/**
 * Created by Administrator on 2017/12/25.
 */
public interface LoginMapper {

    Owner login(Map<String,Object> map);
}
