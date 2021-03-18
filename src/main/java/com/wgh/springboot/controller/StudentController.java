package com.wgh.springboot.controller;

import com.wgh.springboot.bean.Student;
import com.wgh.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wgh on 2021/3/16.
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/insert")
    public int student(Student student) {
        System.out.println("/student/insert");
        System.out.println("student:" + student);
        return studentService.insert(student);
    }


    @DeleteMapping("/deletebystunum")
    public int deleteByStunum(long stunum) {
        System.out.println("/student/deleteByStunum");
        System.out.println("stunum:" + stunum);
        return studentService.deleteByStunum(stunum);
    }


    @PostMapping("/update")
    public int update(Student student) {
        System.out.println("/student/update");
        System.out.println("student:" + student);
        return studentService.update(student);
    }


    @GetMapping("/getbystunum")
    public Student getByStunum(long stunum) {
        System.out.println("/student/getbystunum");
        System.out.println("stunum:" + stunum);
        return studentService.getByStunum(stunum);
    }

}
