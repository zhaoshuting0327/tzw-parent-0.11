package com.tzw.service.impl;

import com.tzw.common.utils.MD5Util;
import com.tzw.mapper.UserMapper;
import com.tzw.pojo.Money;
import com.tzw.pojo.Order;
import com.tzw.pojo.Score;
import com.tzw.pojo.User;
import com.tzw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
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

         //   int orderNum = this.userMapper.orderNum(user.getTzw_user_id());
            BigInteger score = this.userMapper.scoreNum(user.getTzw_user_id());
            Double money = this.userMapper.moneyNum(user.getTzw_user_id());

            if(("").equals(score)||score==null)
            {
                int i1 = Integer.parseInt("0");
                user.setTzw_user_score(BigInteger.valueOf(i1));
            }else
            {
                user.setTzw_user_score(score);
            }

            if(("").equals(money)||money==null)
            {
                user.setTzw_user_money(0.00);
            }else
            {
                user.setTzw_user_money(money);
            }

        //    user.setTzw_user_ordernum(orderNum);
            //判断用户性别
            if(user.getTzw_user_sex()==1)
            {
                user.setTzw_user_sex1("男");
            }else {
                user.setTzw_user_sex1("女");
            }

            //填写用户是否是vip
            if(user.getTzw_user_vip()==3)
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
    public void updateUser(User user,String tzw_money_num,String tzw_score_num) {

        //查询创建时间

        User u=this.findUserById(user.getTzw_user_id());

        String tzw_user_createDate = u.getTzw_user_createDate();


        //添加修改时间
        Date date=new Date();
                                                    //2017-12-05 17:31:49
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");

        String format = simpleDateFormat.format(date);

        user.setTzw_user_updateDate(format);

        System.out.println(user.getTzw_user_money()+"money");
        System.out.println(user.getTzw_user_address()+"address");
        System.out.println(user.getTzw_user_score()+"score");
        System.out.println(user.getTzw_user_phone()+"phone");

        //添加进积分表

        Score score=new Score();

        score.setTzw_score_createDate(tzw_user_createDate);
        score.setTzw_score_desc("后台手动输入");
        score.setTzw_score_type(3);
        score.setTzw_score_id(user.getTzw_user_id());

        this.userMapper.addScore(score);
        //添加进余额表

        Money money=new Money();

        money.setTzw_money_updateDate(format);

        money.setTzw_money_createDate(tzw_user_createDate);

        money.setTzw_money_desc("手动输入");

        money.setTzw_money_type(3);

        money.setTzw_money_user_id(user.getTzw_user_id());
/*
        money.setTzw_money_num();
*/
        this.userMapper.addMoney(money);
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

    @Override
    public List<Score> findScoreById(int cpages, int size, BigInteger tzw_user_id) {

        HashMap<String, Object> objectObjectHashMap = new HashMap<>();

        objectObjectHashMap.put("tzw_score_user_id",tzw_user_id);
        objectObjectHashMap.put("cpage",(cpages-1)*size);
        objectObjectHashMap.put("size",size);
        return this.userMapper.findScoreById(objectObjectHashMap);
    }

    @Override
    public int getScoreCount(BigInteger tzw_user_id) {
        return this.userMapper.getScoreCount(tzw_user_id);
    }

    @Override
    public List<Money> findMoneyById(int cpages, int size, BigInteger tzw_money_user_id) {

        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("tzw_money_user_id",tzw_money_user_id);
        objectObjectHashMap.put("cpage",(cpages-1)*size);
        objectObjectHashMap.put("size",size);
        return this.userMapper.findMoneyById(objectObjectHashMap);
    }

    @Override
    public int getMoneyCount(BigInteger tzw_user_id) {
        return this.userMapper.getMoneyCount(tzw_user_id);
    }

    @Override
    public List<Order> findOrderById(int cpages, int size, BigInteger tzw_user_id) {
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();

        objectObjectHashMap.put("tzw_user_id",tzw_user_id);
        objectObjectHashMap.put("cpage",(cpages-1)*size);
        objectObjectHashMap.put("size",size);
        return this.userMapper.findOrderById(objectObjectHashMap);
    }
    @Override
    public int getOrderCount(BigInteger tzw_user_id) {
        return this.userMapper.getOrderCount(tzw_user_id);
    }
}
