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
        if (student == null) {
            return 0;
        }
        return studentDao.insert(student);
    }

    @Override
    public int deleteByStunum(long stunum) {
        return studentDao.deleteByStunum(stunum);
    }

    @Override
    public int update(Student student) {
        if (student == null) {
            return 0;
        }
        return studentDao.update(student);
    }

    @Override
    public Student getByStunum(long stunum) {
        Student student = studentDao.getByStunum(stunum);
        System.out.println("res student:" + student);
        return student;
    }
}
