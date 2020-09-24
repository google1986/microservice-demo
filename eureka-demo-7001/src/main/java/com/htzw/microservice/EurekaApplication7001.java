package com.htzw.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/9/21 17:18
 */
@SpringBootApplication
@EnableEurekaServer  //EurekaServer服务器端启动类,接受其它微服务注册进来
public class EurekaApplication7001 {
    public static void main(String[] args)
    {
        SpringApplication.run(EurekaApplication7001.class, args);
    }
}
