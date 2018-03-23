package com.tzw.portal.service.impl;

import com.tzw.common.exception.BusinessException;
import com.tzw.common.token.TokenProccessor;
import com.tzw.portal.mapper.LoginMapperPortal;
import com.tzw.portal.pojo.User;
import com.tzw.portal.service.LoginServicePortal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/5.
 */
@Service
public class LoginServiceImplPortal implements LoginServicePortal{

    @Autowired
    private LoginMapperPortal loginMapperPortal;

    //用户名（账号）密码登录

    /**
     * 登录
     */
   /* @Override
    public Map<String, Object> login(User user) throws BusinessException, Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", false);
       //开始登录
        // 查询用户名是否存在
        User operator = new User();
        operator.setTzw_user_username(user.getTzw_user_username());
        User loginUser = this.loginMapperPortal.getUserLogin(operator);
        // 如果存在，则验证用户名与密码是否正确
        if (loginUser != null) {
            operator.setTzw_user_pwd(user.getTzw_user_pwd());
            User userpas = this.loginMapperPortal.getUserLoginp(operator);
            // 如果用户名、密码存在，则设置当前用户
            if (userpas != null) {

                map.put("returnMsg", userpas.getTzw_user_username());
                map.put("flag", true);
                map.put("user", userpas);
              //("登录成功......");
            } else {
                //("密码输入有误，请核对......");
                map.put("returnMsg", "密码输入有误，请核对");
            }
        } else {
          //("没有此账号，请核对......");
            map.put("returnMsg", "没有此用户，请核对");
        }
        return map;
    }*/
    /**
     * 用户名密码登陆
     *
     * @throws Exception
     */
    @Override
    //@Transactional(propagation = Propagation.REQUIRED)
    public Map<String, Object> login(User user) throws BusinessException, Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        //flag 为true表示登录成功  false表示登录失败
        map.put("flag", false);
      //("开始登录......

        // 通过用户名去找用户
        User user1 = this.loginMapperPortal.getUserLogin(user);

        if (user1 != null) {
           // System.out.println("判断用户名是否存在");
            User user2 = this.loginMapperPortal.getUserLoginp(user);
            if (user2 != null) {
            //    System.out.println("判断用户名密码是否正确");
               //map.put("passwordType", teacher.getPasswordType());
                map.put("returnMsg", user.getTzw_user_username());
                map.put("flag", true);
                map.put("uId", user2.getTzw_user_id());
               //生成token 添加进数据库
                TokenProccessor instance = TokenProccessor.getInstance();
                String s = instance.makeToken();
                System.out.println("token:"+s);
                user2.setTzw_user_token(s);
                 this.loginMapperPortal.updateUserToken(user2);
                map.put("token",s);
                //("登录成功......");
            } else {
              //("密码输入有误，请核对......");
                map.put("returnMsg", "密码输入有误，请核对");
                throw new BusinessException("输入密码有误");
            }
        } else {
           //("没有此账号，请核对......");
            map.put("returnMsg", "没有此用户，请核对");
            throw new BusinessException("没有此帐号");
        }
        return map;
    }

    //注册 用户名 手机号 密码
    @Override
    public Map<String, Object> reg(User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", false);
        //开始注册
        // 查询用户名是否存在
        User operator = new User();
        operator.setTzw_user_username(user.getTzw_user_username());
        User loginUser = this.loginMapperPortal.getUserLogin(operator);

        // 如果存在，则验证用户名与密码是否正确
        if (loginUser != null) {

          map.put("returnMsg", "此用户名已经存在");

        } else {
            //查询手机号是否被注册
            User telUser = this.loginMapperPortal.getUserLogint(user);
            if(telUser!=null)
            {
                map.put("returnMsg", "此手机号已被注册");
            }else
            {
                Date date=new Date();
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
                String format = simpleDateFormat.format(date);
                user.setTzw_user_createDate(format);
                //将信息填入user表  用户名  手机号  密码  注册时间
                this.loginMapperPortal.regAdd(user);
                map.put("returnMsg","注册成功");
                map.put("flag", true);
            }
        }
        return map;
    }


    //按用户名查询用户是否存在
    @Override
    public User getByUserName(String username) {
        User user=new User();
        user.setTzw_user_username(username);
        return  this.loginMapperPortal.getUserLogin(user);
    }

    @Override
    public void updateUserToken(String tzw_user_id) {
        Map<String,Object> map=new HashMap<>();
        map.put("tzw_user_id",tzw_user_id);
        this.loginMapperPortal.deleteUserToken(map);
    }

    @Override
    public User lginByTel(String tel) {

        Map<String,Object> map=new HashMap<>();
        map.put("tzw_user_phone",tel);
        User byTel = this.loginMapperPortal.findByTel(map);

        if (byTel==null)
        {
          throw   new BusinessException("此手机号未被注册");
        }else {
            return byTel;
        }
      }

    //手机验证码登录
    @Override
    public Map<String, Object> smsYanZheng(String tel,String code){
        Map<String, Object> map1 = new HashMap<String, Object>();
        //flag 为true表示登录成功  false表示登录失败
        map1.put("flag", false);
        //("开始登录......
        Jedis jedis=new Jedis("60.205.208.183",6379);

        String pwd = null;
        //1. 判断是否缓存该账号验证码
        boolean isExist = jedis.exists(tel + "_smslogin");
        if (isExist) {
            pwd = jedis.get(tel + "_smslogin");   //从redis取出验证码

            //判断是否和输入的验证码一致
            if (code.equals(pwd))
            {
                Map<String,Object> map=new HashMap<>();
                map.put("tzw_user_phone",tel);
                User user = this.loginMapperPortal.findByTel(map);

                map1.put("returnMsg", user.getTzw_user_username());
                map1.put("flag", true);
                map1.put("uId", user.getTzw_user_id());

                //生成token 添加进数据库
                TokenProccessor instance = TokenProccessor.getInstance();
                String s = instance.makeToken();
                System.out.println("token:"+s);
                user.setTzw_user_token(s);
                this.loginMapperPortal.updateUserToken(user);
                map1.put("token",s);
                jedis.del(tel + "_smslogin");
            }else {

                map1.put("returnMsg", "密码验证码有误，请核对");
                throw new BusinessException("输入验证码有误");

            }
         } else {
            //没找到该账号的验证码， 返回错误和提示信息
            map1.put("returnMsg", "请重新获取验证码");
            throw new BusinessException("请重新获取验证码");
        }
        return map1;
    }
}
