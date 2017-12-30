package com.tzw.service;

import com.tzw.pojo.User;

import java.math.BigInteger;
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

    void  updateUser(User user);

    void deleteUser(BigInteger tzw_user_id);


    User findUserById(BigInteger id);

    int getUserCount(String lname);


}
