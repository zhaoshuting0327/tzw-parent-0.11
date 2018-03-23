package com.tzw.portal.service;

import com.tzw.portal.pojo.User;

import java.util.Map;

/**
 * Created by Administrator on 2018/3/5.
 */
public interface LoginServicePortal {

    //登录
    Map<String,Object> login(User user) throws Exception;
    //注册  手机号  密码
    Map<String,Object> reg(User user) throws Exception;

    User getByUserName(String username);

    void   updateUserToken(String tzw_user_id);

    User lginByTel(String tel);

    Map<String,Object> smsYanZheng(String tel,String code);
  ;
}
