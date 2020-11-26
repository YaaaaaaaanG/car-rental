package com.qf.service.Impl;

import com.qf.dao.UserMapper;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Integer insertregister(User user) {
        return userMapper.insertregister(user);
    }

    @Override
    public User selectByTel(String tel) {
        return userMapper.selectByTel(tel);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
