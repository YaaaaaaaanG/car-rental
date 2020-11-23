package com.qf.controller;

import com.qf.common.BaseResp;
import com.qf.pojo.Car;
import com.qf.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/car")
@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping("/selectAllByPrice")
    public BaseResp selectAll(){
        List<Car> cars = carService.selectAllByPrice();
        BaseResp baseResp = new BaseResp();
        baseResp.setCode(1);
        baseResp.setInfo(cars);
        return baseResp;
    }
}
