package com.qf.service;

import com.qf.pojo.Car;

import java.util.List;

public interface CarService {

    List<Car> selectAllByPrice();

    Car selectById(Integer id);
}
