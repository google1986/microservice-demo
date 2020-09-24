package com.htzw.microservice.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *Feign提供了日志打印功能，可以通过配置来调整日志级别，从而了解Feign中Http请求的细节
 *
 * 就是对Feign接口的调用情况进行监控和输出
 * 
 * OpenFeignClient配置——OpenFeign日志打印功能
 *
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/9/23 23:36
 */
@Configuration
public class FeignConfig {

    /**
     * feignClient配置日志级别
     *
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel(){
        //请求和响应的头信息，请求和响应的正文及元数据
        return Logger.Level.FULL;
    }
}
