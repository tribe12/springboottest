package com.wgh.springboot.service;

import com.wgh.springboot.bean.Student;

/**
 * Created by wgh on 2021/3/16.
 */
public interface StudentService {
    public int insert(Student student);

    public int deleteByStunum(long stunum);

    public int update(Student student);

    public Student getByStunum(long stunum);

}
