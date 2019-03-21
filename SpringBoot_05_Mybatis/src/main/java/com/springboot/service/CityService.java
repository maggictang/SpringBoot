package com.springboot.service;

import com.springboot.domain.City;

public interface CityService {

    /**
     * 根据城市名称，查询信息
     */
    City findCityByName(String cityName);
}
