package com.qf.controller;

import com.qf.common.CityBaseResp;
import com.qf.pojo.City;
import com.qf.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/city")
@RestController
@SessionAttributes("user")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/selectAllCity",method = RequestMethod.POST)
    public CityBaseResp selectAllCity(Integer pid){
        List<City> cities = cityService.selectAllCity(pid);
        CityBaseResp cityBaseResp = new CityBaseResp();
        cityBaseResp.setInfo(cities);
        return cityBaseResp;
    }

    @RequestMapping(value = "/selectById",method = RequestMethod.GET)
    public CityBaseResp selectById(Integer getid,Integer backid){
        City getCity = cityService.selectById(getid);
        City backCity = cityService.selectById(backid);
        CityBaseResp cityBaseResp = new CityBaseResp();
        cityBaseResp.setCode(1);
        List list = new ArrayList();
        list.add(getCity);
        list.add(backCity);
        cityBaseResp.setInfo(list);
        return cityBaseResp;
    }
}
