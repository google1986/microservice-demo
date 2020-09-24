package com.htzw.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/9/22 16:17
 */
@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
public class ProviderApplication8002 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication8002.class, args);
    }
}
