package com.springboot.dao.cluster;

import com.springboot.domain.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface CityDao {

    City findByName(@Param("cityName") String cityName);
}
