package com.htzw.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/9/23 9:45
 */
@SpringBootApplication
@EnableEurekaClient
public class ConsumerSleuthApplication9001 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerSleuthApplication9001.class, args);
    }
    /**
     * <bean id=restTemplate class=org.springframework.web.client.RestTemplate/>
     *
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
