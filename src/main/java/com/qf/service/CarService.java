package com.qf.service;

import com.qf.pojo.Car;

import java.util.List;

public interface CarService {

    List<Car> selectAllByPrice();

    List<Car> selectAllByNumber();

    Car selectById(Integer id);
}
