package com.qf.service.Impl;

import com.qf.dao.CityMapper;
import com.qf.pojo.City;
import com.qf.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityMapper cityMapper;

    @Override
    public List<City> selectAllCity() {
        return cityMapper.selectAllCity();
    }
}
