package com.example.spring.cloud.weather.service;

import com.example.spring.cloud.weather.vo.Weather;

/**
 * WeatherReportService 实现
 * 根据城市ID查询天气信息
 * Created by wzy on 2019/12/1
 */
public interface WeatherReportService {
    Weather getDataByCityId(String cityId);
}
