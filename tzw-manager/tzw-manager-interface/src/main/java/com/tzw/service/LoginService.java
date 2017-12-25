package com.tzw.service;

import com.tzw.pojo.Owner;

import java.util.Map;

/**
 * Created by Administrator on 2017/12/25.
 */
public interface LoginService {
    Owner login(String username,String password);
}
