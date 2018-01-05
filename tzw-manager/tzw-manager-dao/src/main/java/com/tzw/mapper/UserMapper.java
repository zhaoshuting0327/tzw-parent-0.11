package com.tzw.mapper;

import com.tzw.pojo.Money;
import com.tzw.pojo.Order;
import com.tzw.pojo.Score;
import com.tzw.pojo.User;

import java.math.BigInteger;
import java.util.HashMap;
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

    List<Score> findScoreById(HashMap<String,Object> map);
    int  getScoreCount(BigInteger tzw_user_id);

    List<Money> findMoneyById(HashMap<String,Object> map);
    int  getMoneyCount(BigInteger tzw_user_id);

    List<Order> findOrderById(HashMap<String,Object> map);
    int  getOrderCount(BigInteger tzw_user_id);

    void addScore(Score score);
    void addMoney(Money money);
}
