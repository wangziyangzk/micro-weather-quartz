package com.example.spring.cloud.weather.vo;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * 城市列表
 * Created by wzy on 2019/8/6
 */
@XmlRootElement(name = "c")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityList {

    @XmlElement(name = "d")
    private List<City> cityList;

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
