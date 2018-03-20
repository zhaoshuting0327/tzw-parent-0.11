package com.tzw.service.impl;

import com.tzw.mapper.LoginMapper;
import com.tzw.pojo.Owner;
import com.tzw.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/25.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;
    @Override
    public Owner login(String username,String password) {

        Map<String,Object> map=new HashMap<>();

        System.out.println(username);
        System.out.println(password);
        map.put("tzw_owner_pwd",password);
        map.put("tzw_owner_name",username);

        return this.loginMapper.login(map);
    }

}
