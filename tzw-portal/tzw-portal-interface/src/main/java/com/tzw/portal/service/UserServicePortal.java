package com.tzw.portal.service;

import com.tzw.portal.pojo.User;

import java.math.BigInteger;

/**
 * Created by Administrator on 2018/1/16.
 */
public interface UserServicePortal {

    User findUserById(BigInteger tzw_user_id);

    int qiandao(BigInteger tzw_user_id);
}
