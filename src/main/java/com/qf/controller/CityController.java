package com.qf.controller;

import com.qf.pojo.City;
import com.qf.service.CityService;
import com.qf.service.Impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/city")
@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/selectAllCity", method = RequestMethod.GET)
    public List<City> selectAllCity(Model model, HttpServletRequest req){
        List<City> cities = cityService.selectAllCity();
        model.addAttribute("city",cities);
        return cities;
    }
}
