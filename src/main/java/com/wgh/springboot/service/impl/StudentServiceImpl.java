package com.wgh.springboot.service.impl;

import com.wgh.springboot.bean.Student;
import com.wgh.springboot.dao.StudentDao;
import com.wgh.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wgh on 2021/3/16.
 */

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public int insert(Student student) {
        if(student == null){
            student = new Student(3656,"佩奇");
            student.setAge(10);
            student.setScore(98);
        }
        return studentDao.insert(student);
    }

    @Override
    public int deleteByStunum(long stunum) {
        return 0;
    }

    @Override
    public int update(Student student) {
        return 0;
    }

    @Override
    public Student getByStunum(long stunum) {
        return null;
    }
}
