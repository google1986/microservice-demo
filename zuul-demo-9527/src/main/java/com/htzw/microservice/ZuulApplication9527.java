package com.htzw.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 *
 * Zuul主要包括对请求的路由和过滤两个功能
 * 1.路由功能负责将外部请求转发到具体的微服务实例上，是实现外部访问统一入口的基础
 * 2.过滤则负责对请求的处理过程进行干预，是实现请求校验、服务聚合等功能的基础
 *
 * Zuul和Eureka进行整合，将Zuul自身注册为Eureka服务治理下的应用，同时从Eureka中获得其他微服务的消息（以后的访问微服务都是通过Zuul跳转后获得）
 *
 *
 * Zuul服务会注册到Eureka上
 *
 *
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/9/23 23:02
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication9527 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication9527.class, args);
    }
}
