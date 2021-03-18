package com.wgh.springboot.controller;

import com.wgh.springboot.bean.Department;
import com.wgh.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wgh on 2021/3/17.
 */
@RestController
@RequestMapping("/dept")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/insert")
    public void insert(Department department) {
        System.out.println("/dept/insert");
        System.out.println("department:" + department);
        departmentService.insert(department);
    }

    @GetMapping("/getbyid")
    public Department getById(Integer id) {
        System.out.println("/dept/getbyid");
        System.out.println("id:" + id);
        return departmentService.getById(id);
    }

    @PostMapping("/update")
    public void update(Department department) {
        System.out.println("/dept/update");
        System.out.println("department:" + department);
        departmentService.update(department);
    }

    @DeleteMapping("/deletebyid")
    public void deleteById(Integer id) {
        System.out.println("/dept/deletebyid");
        System.out.println("id:" + id);
        departmentService.deleteById(id);
    }
}
