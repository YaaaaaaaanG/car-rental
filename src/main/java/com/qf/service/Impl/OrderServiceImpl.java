package com.qf.service.Impl;

import com.github.pagehelper.PageHelper;
import com.qf.dao.OrderMapper;
import com.qf.pojo.Order;
import com.qf.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public Integer insertOrder(Order order) {
        return orderMapper.insertOrder(order);
    }

    @Override
    public Integer deleteById(Integer oid) {
        return orderMapper.deleteById(oid);
    }

    @Override
    public List<Order> selectByLimit(Integer uid,Integer page,Integer limit) {
        PageHelper.startPage(page,limit);
        return orderMapper.selectByLimit(uid);
    }
}
