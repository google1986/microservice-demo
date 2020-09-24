package com.htzw.microservice.dao;

import com.htzw.microservice.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author gu.lian.jun
 * @version 1.0
 * @date 2020/9/22 17:02
 */
@Mapper
public interface DeptDao {
    /**
     * 添加部门信息
     *
     * @param dept 部门对象
     * @return
     */
    boolean addDept(Dept dept);

    /**
     * 根据编号获取部门信息
     *
     * @param id 部门编号
     * @return
     */
    Dept findById(Long id);

    /**
     * 获取所有的部门信息
     * @return
     */
    List<Dept> findAll();
}
