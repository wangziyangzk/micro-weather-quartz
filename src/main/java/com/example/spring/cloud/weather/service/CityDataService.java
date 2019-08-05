package com.example.spring.cloud.weather.service;

import com.example.spring.cloud.weather.vo.City;

import java.util.List;

/**
 * Created by wrb on 2018/8/22
 */
public interface CityDataService {

    /**
     * 获取City列表
     * @return
     * @throws Exception
     */
    List<City> listCity() throws Exception;
}
