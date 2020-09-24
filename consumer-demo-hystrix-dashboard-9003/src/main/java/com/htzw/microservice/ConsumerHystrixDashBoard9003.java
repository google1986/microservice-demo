package com.htzw.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/9/23 22:08
 */
@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerHystrixDashBoard9003 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixDashBoard9003.class, args);
    }
}
