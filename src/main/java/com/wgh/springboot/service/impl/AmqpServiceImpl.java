package com.wgh.springboot.service.impl;

import com.wgh.springboot.amqp.AmqpSender;
import com.wgh.springboot.service.AmqpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wgh on 2021/4/8.
 */
@Service
public class AmqpServiceImpl implements AmqpService {

    @Autowired
    private AmqpSender amqpSender;

    @Override
    public void testSimpleSend() {
        for (int i = 1; i < 6; i++) {
            this.amqpSender.simpleSend("test simpleSend " + i);
        }
    }

    @Override
    public void testPsSend() {
        for (int i = 1; i < 6; i++) {
            this.amqpSender.psSend("test psSend " + i);
        }
    }

    @Override
    public void testRoutingSend() {
        for (int i = 1; i < 6; i++) {
            this.amqpSender.routingSend("order", "test routingSend " + i);
        }
    }

    @Override
    public void testTopicSend() {
        for (int i = 1; i < 6; i++) {
            this.amqpSender.topicSend("user.add", "test topicSend " + i);
        }
    }
}
