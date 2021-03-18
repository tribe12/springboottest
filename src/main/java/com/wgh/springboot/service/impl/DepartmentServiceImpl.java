package com.wgh.springboot.service.impl;

import com.wgh.springboot.bean.Department;
import com.wgh.springboot.mapper.DepartmentMapper;
import com.wgh.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wgh on 2021/3/17.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public void insert(Department department) {
        departmentMapper.insert(department);
    }

    @Override
    public Department getById(Integer id) {
        Department department = departmentMapper.getById(id);
        System.out.println("department:" + department);
        return department;
    }

    @Override
    public void update(Department department) {
        departmentMapper.update(department);
    }

    @Override
    public void deleteById(Integer id) {
        departmentMapper.deleteById(id);
    }
}
