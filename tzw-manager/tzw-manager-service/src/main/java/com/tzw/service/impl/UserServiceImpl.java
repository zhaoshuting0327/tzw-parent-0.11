package com.tzw.service.impl;

import com.tzw.mapper.UserMapper;
import com.tzw.pojo.User;
import com.tzw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/24.
 */
@Service
public class UserServiceImpl  implements UserService{

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findUserList(String lname, int page, int rows) {

        HashMap<String, Object> objectObjectHashMap = new HashMap<>();

        objectObjectHashMap.put("lname",lname);
        objectObjectHashMap.put("index",(page-1)*rows);
        objectObjectHashMap.put("rows",rows);

        List<User> list=this.userMapper.findUserList(objectObjectHashMap);


        for (int i=0;i<list.size();i++)
        {
            //添加用户金额

            //添加用户积分
            //添加用户订单数

           User user= list.get(i);

           user.setTzw_user_ordernum(this.userMapper.orderNum(user.getTzw_user_id()));
           user.setTzw_user_score(this.userMapper.scoreNum(user.getTzw_user_id()));
           user.setTzw_user_money(this.userMapper.moneyNum(user.getTzw_user_id()));
        }
        int total =this.userMapper.getTotal(objectObjectHashMap);

        return list;
    }

    @Override
    public void updateUser(User user) {

        this.userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(BigInteger tzw_user_id) {

        this.userMapper.deleteUser(tzw_user_id);
    }


    @Override
    public User findUserById(BigInteger id) {
        return this.userMapper.findUserById(id);
    }
}
