package com.htzw.microservice.ctrl;

import com.htzw.microservice.entities.Dept;
import com.htzw.microservice.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/9/23 9:49
 */
@RestController
public class DeptController {

    @Autowired
    private DeptClientService deptClientService;

    @PostMapping(value="/consumer/dept/add")
    public boolean add(Dept dept)
    {
        return deptClientService.add(dept);
    }

    @GetMapping(value="/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
        return deptClientService.get(id);
    }

    @GetMapping(value="/consumer/dept/list")
    public List<Dept> list()
    {
        return deptClientService.list();
    }
}
