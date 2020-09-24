package com.htzw.microservice.ctrl;

import com.htzw.microservice.entities.Dept;
import com.htzw.microservice.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/9/22 17:10
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService service;

    @PostMapping(value="/dept/add")
    public boolean add(@RequestBody Dept dept)
    {
        return service.add(dept);
    }

    @GetMapping(value="/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
        return service.get(id);
    }

    @GetMapping(value="/dept/list")
    public List<Dept> list()
    {
        return service.list();
    }
}
