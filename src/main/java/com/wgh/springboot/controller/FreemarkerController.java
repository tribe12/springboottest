package com.wgh.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by wgh on 2021/3/15.
 */
@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {

    @GetMapping("/hello")
    public String hello(Map<String,Object> map) {
        map.put("msg", "Hello Freemarker");
        return "hello_freemarker";
    }
}