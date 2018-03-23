package com.tzw.portal.mapper;

import com.tzw.portal.pojo.User;

import java.util.Map;

/**
 * Created by Administrator on 2018/3/5.
 */
public interface LoginMapperPortal {

    //查看用户名是否存在
  User getUserLogin(User user);
  //查看用户名密码是否正确
  User getUserLoginp(User user);
  //查询手机号是否被注册
  User getUserLogint(User user);

  void regAdd(User user);
  //登录之后修改token
  void updateUserToken(User user);

  //登出销毁token
 void deleteUserToken(Map<String,Object> map);

    User findByTel(Map<String,Object> map);
}
