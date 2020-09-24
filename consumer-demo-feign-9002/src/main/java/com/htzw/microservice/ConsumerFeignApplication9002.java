package com.htzw.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 *
 * 在Springcloud应用中，使用feign客户端，需要做以下几个件事：
 * 1.使用注解@EnableFeignClients启用feign客户端
 * 2.使用注解@FeignClient定义feign客户端
 * 3.使用注解@Autowired使用上面所定义feign的客户端
 *
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/9/23 9:45
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.htzw.microservice")
public class ConsumerFeignApplication9002 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignApplication9002.class, args);
    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }}
