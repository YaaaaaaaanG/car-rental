package com.qf.service;

import com.qf.pojo.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CityService {

    List<City> selectAllCity(@Param("pid") Integer pid);

    City selectById(@Param("id")Integer id);
}
