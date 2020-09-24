package com.htzw.microservice;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * ===============hystrix 服务熔断==================
 * 熔断机制是应对雪崩效应的一种微服务链路保护机制
 * 当扇出链路的某个微服务不可用或者响应时间太长时，会进行服务的降级，进而熔断该节点微服务的调用，
 * 快速返回错误的响应信息。
 *
 * 当检测到该阶段微服务调用响应正常后恢复调用链路。
 *
 * 在Spring Cloud框架里熔断机制通过Hystrix实现。
 *
 * Hystrix会监控微服务间调用的状况，当失败的调用到一定阈值（默认是5秒内20次调用失败）就会启动熔断机制
 *
 * 熔断机制的注解是@HystrixCommand
 *
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/9/22 16:17
 */
@SpringBootApplication
@EnableEurekaClient // 本服务启动后会自动注册进eureka服务中
@EnableCircuitBreaker // 开启hystrix熔断机制
public class ProviderHystrixApplication8001 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderHystrixApplication8001.class, args);
    }

    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
