package com.htzw.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/9/24 6:28
 */
@SpringBootApplication
@EnableEurekaClient
public class GateWayApplication9527 {
    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication9527.class, args);
    }
}
