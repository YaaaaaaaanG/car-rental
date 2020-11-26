package com.qf.dao;

import com.qf.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    Integer insertregister(User user);

    User selectByTel(@Param("tel") String tel);

    Integer updateUser(User user);
}
