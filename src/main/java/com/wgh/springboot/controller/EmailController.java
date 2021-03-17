package com.wgh.springboot.controller;

import com.wgh.springboot.config.JavaMailComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by wgh on 2021/3/17.
 */
@Controller("/email")
public class EmailController {
    @Autowired
    private JavaMailComponent javaMailComponent;


    @GetMapping("/test")
    public void test(){
        javaMailComponent.sendMail("451641760@qq.com");
    }

}
