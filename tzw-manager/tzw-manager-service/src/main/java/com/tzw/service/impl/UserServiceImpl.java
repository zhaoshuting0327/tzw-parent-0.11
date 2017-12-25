package com.tzw.service.impl;

import com.tzw.mapper.UserMapper;
import com.tzw.pojo.User;
import com.tzw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/12/24.
 */
@Service
public class UserServiceImpl  implements UserService{

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> userList() {
        return this.userMapper.userList();
    }

}
