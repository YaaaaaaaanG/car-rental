package com.qf.controller;

import com.qf.common.BaseResp;
import com.qf.pojo.Car;
import com.qf.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/car")
@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping("/selectAllByPrice")
    public BaseResp selectAllByPrice(){
        List<Car> cars = carService.selectAllByPrice();
        BaseResp baseResp = new BaseResp();
        baseResp.setCode(1);
        baseResp.setInfo(cars);
        return baseResp;
    }

    @RequestMapping("/selectAllByNumber")
    public BaseResp selectAllByNumber(){
        List<Car> cars = carService.selectAllByNumber();
        BaseResp baseResp = new BaseResp();
        baseResp.setCode(1);
        baseResp.setInfo(cars);
        return baseResp;
    }

    @RequestMapping("/selectById")
    public BaseResp selectById(Integer cid){
        Car car = carService.selectById(cid);
        ArrayList arrayList = new ArrayList();
        arrayList.add(car);
        BaseResp baseResp = new BaseResp();
        baseResp.setCode(1);
        baseResp.setInfo(arrayList);
        return baseResp;
    }
}
