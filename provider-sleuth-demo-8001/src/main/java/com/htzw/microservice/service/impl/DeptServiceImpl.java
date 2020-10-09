package com.htzw.microservice.service.impl;

import com.htzw.microservice.dao.DeptDao;
import com.htzw.microservice.entities.Dept;
import com.htzw.microservice.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/9/22 17:05
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao dao;

    public boolean add(Dept dept)
    {
        return dao.addDept(dept);
    }

    public Dept get(Long id)
    {
        return dao.findById(id);
    }

    public List<Dept> list()
    {
        return dao.findAll();
    }
}
