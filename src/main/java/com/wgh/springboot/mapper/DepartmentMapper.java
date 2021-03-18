package com.wgh.springboot.mapper;

import com.wgh.springboot.bean.Department;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by wgh on 2021/3/17.
 */
@Mapper
public interface DepartmentMapper {

    public void insert(Department department);

    public Department getById(Integer id);

    public void update(Department department);

    public void deleteById(Integer id);
}