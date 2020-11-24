package com.qf.service.Impl;

import com.qf.dao.CarMapper;
import com.qf.pojo.Car;
import com.qf.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarMapper carMapper;

    @Override
    public List<Car> selectAllByPrice() {

        return carMapper.selectAllByPrice();
    }

    @Override
    public List<Car> selectAllByNumber(){
        return carMapper.selectAllByNumber();
    }

    @Override
    public Car selectById(Integer id) {
        return carMapper.selectById(id);
    }
}
