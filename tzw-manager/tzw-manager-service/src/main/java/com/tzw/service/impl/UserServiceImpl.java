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
    public List<User> findUserList(String lname, int cpage, int size) {

        HashMap<String, Object> objectObjectHashMap = new HashMap<>();

        objectObjectHashMap.put("lname",lname);
        objectObjectHashMap.put("cpage",(cpage-1)*size);
        objectObjectHashMap.put("size",size);

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

            //判断用户性别
            if(user.getTzw_user_sex()==1)
            {
                user.setTzw_user_sex1("男");
            }else {
                user.setTzw_user_sex1("女");
            }

            //填写用户是否是vip
            if(user.getTzw_user_vip()==1)
            {
                user.setTzw_user_vip1("是");
            }else
            {
                user.setTzw_user_vip1("否");

            }

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

    @Override
    public int getUserCount(String lname) {

        HashMap<String,Object> map=new HashMap<>();

        map.put("lname",lname);

        return this.userMapper.getTotal(map);
    }
}
