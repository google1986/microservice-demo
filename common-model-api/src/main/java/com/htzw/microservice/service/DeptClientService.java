package com.htzw.microservice.service;

import com.htzw.microservice.entities.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


/**
 * 内置负载均衡，整合ribbon实现的
 *
 * feign会根据不同的方法，来构造url去请求
 *
 *
 * Feign通过接口的方法调用Rest服务（之前是Ribbon+RestTemplate），
 * 该请求发送给Eureka服务器（http://MICROSERVICE-DEPT/dept/list）,
 * 通过Feign直接找到服务接口，由于在进行服务调用的时候融合了Ribbon技术，所以也支持负载均衡作用。
 *
 *
 *
 * *************************************@FeignClient说明***********************************
 * FeignClient注解被@Target(ElementType.TYPE)修饰，表示FeignClient注解的作用目标在接口上
 *1.从源码可以得知，name是value的别名，value也是name的别名。两者的作用是一致的，name指定FeignClient的名称，
 * 如果项目使用了Ribbon，name属性会作为微服务的名称，用于服务发现
 * 2.url属性一般用于调试程序，允许我们手动指定@FeignClient调用的地址
 * 3.fallbackFactory：工厂类，用于生成fallback类示例，通过这个属性我们可以实现每个接口通用的容错逻辑，减少重复的代码。
 * ***********************************************************************************
 *
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/9/23 11:23
 */
@FeignClient(value = "MICROSERVICE-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    /**
     * 当该方法被调用时，feign会构造：
     * http://MICROSERVICE-DEPT/dept/get/{id}并去请求
     *
     * @param id 部门编号
     *
     * @return
     */
    @GetMapping(value = "/dept/get/{id}")
    Dept get(@PathVariable("id") long id);

    /**
     * 获取所有的部门信息
     *
     * @return
     */
    @GetMapping(value = "/dept/list")
    List<Dept> list();

    /**
     * 新增部门信息
     *
     * @param dept 部门对象
     *
     * @return
     */
    @PostMapping(value = "/dept/add")
    boolean add(Dept dept);
}
