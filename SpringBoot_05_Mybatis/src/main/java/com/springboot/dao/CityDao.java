package com.springboot.dao;

import com.springboot.domain.City;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

public interface CityDao {

    City findByName(@Param("cityName") String cityName);
}
