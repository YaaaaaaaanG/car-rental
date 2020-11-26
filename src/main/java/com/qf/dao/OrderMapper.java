package com.qf.dao;

import com.qf.pojo.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    Integer insertOrder(Order order);

    Integer deleteById(@Param("oid") Integer oid);

    List<Order> selectByLimit(@Param("uid")Integer uid);
}
