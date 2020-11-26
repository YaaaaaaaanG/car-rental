package com.qf.service;

import com.qf.pojo.Order;

import java.util.List;

public interface OrderService {

    Integer insertOrder(Order order);

    Integer deleteById(Integer oid);

    List<Order> selectByLimit(Integer uid,Integer page,Integer limit);
}
