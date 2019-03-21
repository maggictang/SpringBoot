package com.springboot.service.service;

import com.springboot.domain.City;

public interface CityService {

    City findByName(String cityName);
}
