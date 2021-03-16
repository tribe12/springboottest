package com.wgh.springboot.bean;

/**
 * Created by wgh on 2021/3/15.
 */
public class Student {
    private long id;
    private long stunum;
    private String name;
    private int age;
    private double score;

    public Student() {
    }

    public Student(long id, long stunum, String name) {
        this.id = id;
        this.stunum = stunum;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public long getStunum() {
        return stunum;
    }

    public void setStunum(long stunum) {
        this.stunum = stunum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stunum=" + stunum +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
