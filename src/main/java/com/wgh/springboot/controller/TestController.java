package com.wgh.springboot.controller;

import com.wgh.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wgh on 2021/3/12.
 */
@RestController
public class TestController {

    @GetMapping("/helloworld")
    public String helloworld() {
        System.out.println("SpringBoot Test HelloWorld");
        return "SpringBoot Test HelloWorld";

    }

    @GetMapping("/helloworld2")
    public String helloworld2() {
        System.out.println("SpringBoot Test HelloWorld2");
        return "SpringBoot Test HelloWorld2";
    }

    @GetMapping("/map")
    public Map map() {
        System.out.println("SpringBoot Test map");
        HashMap<Object, Object> map = new HashMap<>();
        map.put(1, "一");
        map.put(2, "二");
        map.put(3, "三");
        return map;
    }

    @GetMapping("/stu")
    public Student student() {
        System.out.println("SpringBoot Test student");
        return new Student(123, 534631, "佩德罗");
    }

    @GetMapping("/err")
    public String error() {
        System.out.println("SpringBoot Test error");
        int i = 1 / 0;
        return "SpringBoot Test error";
    }

    @GetMapping("/err2")
    public String error2() {
        System.out.println("SpringBoot Test error2");
        String s = null;
        if (s.equals(null)) {
            System.out.println("s.equals(null)");
        }
        return "SpringBoot Test error2";
    }


}
