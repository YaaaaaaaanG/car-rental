package com.qf.dao;

import com.qf.pojo.City;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityMapper {

    List<City> selectAllCity(@Param("pid") Integer pid);

    City selectById(@Param("id")Integer id);
}
