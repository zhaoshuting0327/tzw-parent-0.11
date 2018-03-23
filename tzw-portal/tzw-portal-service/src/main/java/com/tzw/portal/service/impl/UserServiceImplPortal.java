package com.tzw.portal.service.impl;

import com.tzw.portal.mapper.UserMapperPortal;
import com.tzw.portal.pojo.JiFen;
import com.tzw.portal.pojo.Score;
import com.tzw.portal.pojo.User;
import com.tzw.portal.service.UserServicePortal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/18.
 */
@Service
public class UserServiceImplPortal implements UserServicePortal{


    @Autowired
    private UserMapperPortal userMapperPortal;
    @Override
    public User findUserById(BigInteger tzw_user_id) {

        User userById = this.userMapperPortal.findUserById(tzw_user_id);

        /*当前余额 1 增  2减*/
        BigInteger addMoney=this.userMapperPortal.addMoney(tzw_user_id);
        BigInteger jianMoney=this.userMapperPortal.jianMoney(tzw_user_id);

        int jia1 = Integer.parseInt(addMoney + "");
        int jian1 = Integer.parseInt(jianMoney + "");

        int i1 = jia1 - jian1;

        userById.setTzw_user_money(Double.valueOf(i1));

        /*当前积分*/
        BigInteger addScore=this.userMapperPortal.jianScore(tzw_user_id);
        BigInteger jianScore=this.userMapperPortal.jianScore(tzw_user_id);

        int jia = Integer.parseInt(addScore + "");
        int jian = Integer.parseInt(jianScore + "");

        int i = jia - jian;

        userById.setTzw_user_score(BigInteger.valueOf(i));

        return  userById;
    }

    @Override
    public int qiandao(BigInteger tzw_user_id) {

        //先查是否签过到 包前不包后
        User userById = this.userMapperPortal.findUserById(tzw_user_id);

        String tzw_user_sign = userById.getTzw_user_sign();

        Date date=new Date();

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");

        String format = simpleDateFormat.format(date);

        String substring = format.substring(0, 10);
        String substring1="";
        if (tzw_user_sign!=null) {
             substring1 = tzw_user_sign.substring(0, 10);
            System.out.println("数据库时间"+format);
        }

        System.out.println("现在时间"+format);



        if(tzw_user_sign!=null&&substring.equals(substring1)) {
            //已经签过到
            System.out.println("进了2");
                 return 2;
        }
        Integer tzw_user_qiandao = userById.getTzw_user_qiandao();

        if((tzw_user_sign==null&&tzw_user_qiandao==0)||(!substring.equals(substring1))) {
            //签到送10积分  添加到积分表
            Score score=new Score();
            score.setTzw_score_createDate(format);
            score.setTzw_score_desc("签到");
            score.setTzw_score_user_id(tzw_user_id);
            score.setTzw_score_num(BigInteger.valueOf(10));
            this.userMapperPortal.addQianDaoScore(score);
            //添加签到时间，添加积分描述 user表
            userById.setTzw_user_qiandao(1+tzw_user_qiandao);
            userById.setTzw_user_sign(format);
            this.userMapperPortal.updateSign( userById);
            System.out.println("进了1");
            return 1;
        }
         return  0;
    }


}
