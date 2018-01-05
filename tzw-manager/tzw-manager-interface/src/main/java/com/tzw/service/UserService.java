package com.tzw.service;

import com.tzw.pojo.Money;
import com.tzw.pojo.Order;
import com.tzw.pojo.Score;
import com.tzw.pojo.User;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Administrator on 2017/12/24.
 */
public interface UserService {

 /*   List<User> userList(String lname,int page,int rows);

    void  updateUser(User user);

    void deleteUser(int tzw_user_id);*/

    List<User> findUserList(String lname,int page,int rows);

    void  updateUser(User user,String tzw_money_num,String tzw_score_num);

    void deleteUser(BigInteger tzw_user_id);


    User findUserById(BigInteger id);

    int getUserCount(String lname);

//        List<Score> scoreList = this.userService.findScoreById( Integer.parseInt(cpages), size,tzw_user_id);
    List<Score> findScoreById(int cpages,int size,BigInteger tzw_user_id);

    int  getScoreCount(BigInteger tzw_user_id);


    List<Money> findMoneyById(int cpages,int size,BigInteger tzw_money_user_id);
    int  getMoneyCount(BigInteger tzw_user_id);

    List<Order> findOrderById(int cpages,int size,BigInteger tzw_user_id);
    int  getOrderCount(BigInteger tzw_user_id);







}
