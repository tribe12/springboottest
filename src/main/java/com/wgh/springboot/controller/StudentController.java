package com.wgh.springboot.controller;

import com.wgh.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wgh on 2021/3/16.
 */
@RestController("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/insert")
    public int student() {
        System.out.println("/student/insert");
        return studentService.insert(null);
    }
}
