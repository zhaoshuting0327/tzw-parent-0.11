package com.tzw.portal.controller;

import com.tzw.portal.mapper.UserMapperPortal;
import com.tzw.portal.pojo.User;
import com.tzw.portal.service.UserServicePortal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigInteger;

/**
 * Created by Administrator on 2018/1/18.
 */
@Controller
@RequestMapping("/portal/user")
public class UserController {

    @Autowired
    private UserServicePortal userServicePortal;

    @RequestMapping("findUserById")
    @ResponseBody
    public User findUserById(HttpSession session)
    {
        BigInteger i = null;
        if(session.getAttribute("tzw_user_id")!=null)
        {
            int i1 = Integer.parseInt((String) session.getAttribute("tzw_user_id"));
             i=BigInteger.valueOf(i1);
        }
        return this.userServicePortal.findUserById(BigInteger.valueOf(1));
    }

    /*签到*/
    @RequestMapping(value = "/qiandao",method= RequestMethod.POST)
    @ResponseBody
    public int qiandao(BigInteger tzw_user_id)
    {
        int i= this.userServicePortal.qiandao(tzw_user_id);
        //2表示已签到
        //1表示签到成功
        return i;
    }



}
