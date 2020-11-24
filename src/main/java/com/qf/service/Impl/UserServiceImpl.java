package com.qf.service.Impl;

import com.qf.dao.UserMapper;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper usermapper;

    @Override
    public User login(User user) {
        return usermapper.login(user);
    }

    @Override
    public Integer register(User user) {
        return usermapper.register(user);
    }
}
