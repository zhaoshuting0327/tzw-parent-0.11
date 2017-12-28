package com.tzw.mapper;

import com.tzw.pojo.User;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/28.
 */
public interface UserMapper {

    List<User> findUserList(Map<String,Object> map);

    void  updateUser(User user);

    void deleteUser(BigInteger tzw_user_id);

    int getTotal(Map<String,Object> map);

    User findUserById(BigInteger id);

    //添加用户金额

    //添加用户积分
    //添加用户订单数

    BigInteger scoreNum(BigInteger id);
    Double moneyNum(BigInteger id);
    int orderNum(BigInteger id);
}
