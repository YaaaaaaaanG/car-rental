package com.qf.service;

import com.qf.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    Integer insertregister(User user);

    User selectByTel(@Param("tel") String tel);

    Integer updateUser(User user);
}
