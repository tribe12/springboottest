package com.wgh.springboot.controller;

import com.wgh.springboot.config.JavaMailComponent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by wgh on 2021/3/12.
 */
@Controller
public class TestController2 {
    @RequestMapping("/f")
    public String freemarker(Map<String,Object> map) {
        map.put("msg", "Hello Freemarker2");
        System.out.println("SpringBoot Test hello_freemarker2");
        return "hello_freemarker";
    }

    @RequestMapping("/t")
    public String thymeleaf(Map<String,Object> map) {
        map.put("msg", "Hello Thymeleaf2");
        System.out.println("SpringBoot Test hello_thymeleaf2");
        return "hello_thymeleaf";
    }

    @RequestMapping("/mail")
    public void javamail(Map<String,Object> map) {
        JavaMailComponent javaMailComponent = new JavaMailComponent();
        javaMailComponent.sendMail("451641760@qq.com");

    }
}
