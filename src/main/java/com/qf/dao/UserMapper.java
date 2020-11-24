package com.qf.dao;

import com.qf.pojo.User;

public interface UserMapper {

    User login(User user);

    Integer register(User user);
}
