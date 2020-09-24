package com.htzw.microservice.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 *
 * 自定义全局过滤器
 * 主要实现GlobalFilter和OrderId接口
 *
 * 通过全局GlobalFilter可以实现
 * 1.全局日志记录
 * 2.统一网关鉴权
 *
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/9/24 8:43
 */

@Component
@Slf4j
public class MyGateWayFilter implements GlobalFilter,Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("---------------------进入全局GlobalFilter:{}", new Date());
        String name = exchange.getRequest().getQueryParams().getFirst("name");
        if (name == null) {
            log.error("============用户名为空，非法用户禁入");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    /**
     * 过滤器加载的顺序越小，优先级就越高
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
