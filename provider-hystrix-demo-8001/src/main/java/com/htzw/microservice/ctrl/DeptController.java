package com.htzw.microservice.ctrl;

import com.htzw.microservice.entities.Dept;
import com.htzw.microservice.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ================@HystrixCommand=========================
 * @HystrixCommand：一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod
 * 调用类中的指定方法
 *
 *
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/9/22 17:10
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService service;

    @GetMapping(value="/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "deptHystrix_Get")
    public Dept get(@PathVariable("id") Long id)
    {
        Dept dept =  service.get(id);
        if(null == dept)
        {
            throw new RuntimeException("该ID："+id+"没有没有对应的信息");
        }
        return dept;
    }
    public Dept deptHystrix_Get(@PathVariable("id") Long id){
        Dept errorDept = new Dept();
        errorDept.setDeptno(id).setDname("没有找到对应的信息，@HystrixCommand")
                .setDb_source("no this database");
        return errorDept;
    }
}
