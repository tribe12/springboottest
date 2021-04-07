package com.wgh.springboot.service.impl;

import com.wgh.springboot.mapper.DepartmentMapper;
import com.wgh.springboot.bean.Department;
import com.wgh.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by wgh on 2021/3/17.
 */
@CacheConfig(cacheNames = "department")
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @CachePut(key = "#department.id")
    @Override
    public void insert(Department department) {
        System.out.println("保存 id=" + department.getId() + " 的数据");
        departmentMapper.insert(department);
    }

    @Cacheable(key = "#id")
    @Override
    public Department getById(Integer id) {
        Department department = departmentMapper.getById(id);
        System.out.println("获取 id=" + id + " 的数据");
        System.out.println("department:" + department);
        return department;
    }

    @Override
    public void update(Department department) {
        departmentMapper.update(department);
    }

    @CacheEvict(key = "#id")
    @Override
    public void deleteById(Integer id) {
        System.out.println("删除 id=" + id + " 的数据");
        departmentMapper.deleteById(id);
    }
}
