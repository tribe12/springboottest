package com.wgh.springboot.dao.impl;

import com.wgh.springboot.bean.Student;
import com.wgh.springboot.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wgh on 2021/3/16.
 */
@Repository
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Student student) {
        String sql = "insert into student(id,stunum,`name`,age,score) values(?,?,?,?,?)";
        return this.jdbcTemplate.update(
                sql,
                student.getId(),
                student.getStunum(),
                student.getName(),
                student.getAge(),
                student.getScore()
        );

    }

    @Override
    public int deleteByStunum(long stunum) {
        String sql = "delete from student where stunum = ?";
        return this.jdbcTemplate.update(sql, stunum);
    }

    @Override
    public int update(Student student) {
        String sql = "update student set stunum = ?, `name`= ?, age= ?, score= ? where stunum = ?";
        return this.jdbcTemplate.update(
                sql,
                student.getStunum(),
                student.getName(),
                student.getAge(),
                student.getScore(),
                student.getId()
        );
    }

    @Override
    public Student getByStunum(long stunum) {
        String sql = "select * from student where stunum = ? limit 1";
        return this.jdbcTemplate.queryForObject(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setStunum(rs.getLong("stunum"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setScore(rs.getDouble("score"));
                return student;
            }
        }, stunum);
    }
}
