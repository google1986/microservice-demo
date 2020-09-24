package com.htzw.microservice.service;


import com.htzw.microservice.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * 服务降级处理类
 *
 * 服务降级处理是在客户端实现的，与服务端没关系
 *
 *
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/7/28 10:16
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>
{
    @Override
    public DeptClientService create(Throwable throwable)
    {
        return new DeptClientService() {
            @Override
            public Dept get(long id)
            {
                return new Dept().setDeptno(id)
                        .setDname("该ID："+id+"没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
                        .setDb_source("no this database in MySQL");
            }

            @Override
            public List<Dept> list()
            {
                return Collections.emptyList();
            }

            @Override
            public boolean add(Dept dept)
            {
                return false;
            }
        };
    }
}

