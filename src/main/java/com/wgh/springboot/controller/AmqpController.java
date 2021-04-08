package com.wgh.springboot.controller;

import com.wgh.springboot.service.AmqpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wgh on 2021/4/8.
 */
@RestController
@RequestMapping("/amqp")
public class AmqpController {

    @Autowired
    private AmqpService amqpService;

    @GetMapping("/testsimplesend")
    public void testSimpleSend() {
        amqpService.testSimpleSend();
    }

    @GetMapping("/testpssend")
    public void testPsSend() {
        amqpService.testPsSend();
    }

    @GetMapping("/testroutingsend")
    public void testRoutingSend() {
        amqpService.testRoutingSend();
    }

    @GetMapping("/testtopicsend")
    public void testTopicSend() {
        amqpService.testTopicSend();
    }
}
