package com.htzw.microservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * GateWay网关路由配置，以下为代码注入方式
 *
 * 有两种配置方式
 * 1、在配置文件yaml中配置
 * 2、代码中注入RouteLocator的Bean
 *
 *
 * 案例：
 * 通过9527网关放到到外网的百度新闻地址
 *
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/9/24 6:36
 */
@Configuration
public class GateWayConfig {
    /**
     * 配置一个id为path_route_demo的路由规则：
     * 当访问地址为：http://localhost:9527/guinei时会自动转发到地址：http://news.baidu.com/guonei
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_guonei_demo", route -> route.path("/guonei").uri("http://news.baidu.com/guonei"));
        return routes.build();
    }
    @Bean
    public RouteLocator customerRouteLocator2(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_guoji_demo",route -> route.path("/guoji").uri("http://news.baidu.com/guoji"));
        return routes.build();
    }

}
