package com.htzw.microservice;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

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
