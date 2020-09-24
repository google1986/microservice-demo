package com.htzw.microservice.service;

import com.htzw.microservice.entities.Dept;

import java.util.List;

/**
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/9/22 17:04
 */
public interface DeptService {
    /**
     * 添加部门
     *
     * @param dept 部门对象
     * @return
     */
    boolean add(Dept dept);

    /**
     * 根据编号获取部门信息
     *
     * @param id 部门编号
     * @return
     */
    Dept get(Long id);

    /**
     * 获取所有的部门信息
     *
     * @return
     */
    List<Dept> list();
}
