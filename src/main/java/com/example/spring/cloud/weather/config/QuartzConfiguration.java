package com.example.spring.cloud.weather.config;

import com.example.spring.cloud.weather.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wzy on 2019/8/6
 */
@Configuration
public class QuartzConfiguration {

    private  static final int TIME = 1800;//更新频率
    //JobDetail 用于定义一个特定的一个Job
    @Bean
    public JobDetail weatherDataSyncJobDetail() {
        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob")
                .storeDurably().build();
    }

    //Trigger 定义的Job何时触发
    @Bean
    public Trigger weatherDataSyncTrigger() {
        SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(TIME).repeatForever();
        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail())
                .withIdentity("weatherDataSyncJobDetail").withSchedule(schedBuilder).build();
    }
}
