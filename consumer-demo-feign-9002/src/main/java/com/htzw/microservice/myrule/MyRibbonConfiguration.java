package com.htzw.microservice.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 当前服务请求MICROSERVICE-DEPT时，会使用MySelfRule里面的配置
 *
 * 在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，从  而使配置生效
 *
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/9/23 9:45
 */
@Configuration
@RibbonClient(name = "MICROSERVICE-DEPT",configuration = MySelfRule.class)
public class MyRibbonConfiguration {
}

class MySelfRule {
    @Bean
    public IRule randomRule() {
        // Ribbon默认是轮询，改为随机
        return new RandomRule();
        //return new RoundRobinRule();// Ribbon默认是轮询，我自定义为随机
    }
}