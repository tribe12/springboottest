package com.wgh.springboot.service;

/**
 * Created by wgh on 2021/4/8.
 */
public interface AmqpService {

    public void testSimpleSend();
    public void testPsSend();
    public void testRoutingSend();
    public void testTopicSend();
}
