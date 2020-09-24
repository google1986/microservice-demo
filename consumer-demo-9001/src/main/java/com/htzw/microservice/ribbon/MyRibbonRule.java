package com.htzw.microservice.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import com.netflix.niws.loadbalancer.DiscoveryEnabledServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/9/23 9:45
 */
public class MyRibbonRule extends AbstractLoadBalancerRule {

    @Autowired
    EurekaInstanceConfigBean eurekaInstanceConfigBean;


    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }

    @Override
    public Server choose(Object key) {
        // 1. 读取本地的配置
        Map<String, String> metadataMap = eurekaInstanceConfigBean.getMetadataMap();
        String version = metadataMap.get("version");

        // 2. 从本地缓存(serverlist)里面获取所有实例
        ILoadBalancer loadBalancer = this.getLoadBalancer();
        List<Server> servers = loadBalancer.getReachableServers();

        // 3. 从实例列表里面筛选出metadata匹配的实例
        List<Server> metadataMatchedServers = servers.stream()
                .filter(server -> {
                    DiscoveryEnabledServer server1 = (DiscoveryEnabledServer) server;
                    Map<String, String> metadata = server1.getInstanceInfo().getMetadata();
                    String targetVersion = metadata.get("version");
                    return Objects.equals(version, targetVersion);
                }).collect(Collectors.toList());

        if (CollectionUtils.isEmpty(metadataMatchedServers)) {
            return null;
        }

        // 4. 负载均衡规则，选择1个实例去调用
        int i = ThreadLocalRandom.current().nextInt(metadataMatchedServers.size());
        return metadataMatchedServers.get(i);
    }
}
