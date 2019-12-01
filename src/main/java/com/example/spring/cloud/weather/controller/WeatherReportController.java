package com.example.spring.cloud.weather.controller;

import com.example.spring.cloud.weather.service.CityDataService;
import com.example.spring.cloud.weather.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * WeatherReportService 实现
 * 根据城市ID查询天气信息
 * Created by wzy on 2019/12/1
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherReportService weatherReportService;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getWeatherByCityId(@PathVariable("cityId")String cityId, Model model) throws Exception {
        model.addAttribute("title","天气预报");
        model.addAttribute("cityId",cityId);
        model.addAttribute("cityList",cityDataService.listCity());
        model.addAttribute("report",weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report","reportModel",model);
    }
}
