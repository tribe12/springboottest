package com.wgh.springboot.config.timedtask.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 *
 * 定时器的实现有 2 种方式：
 *
 * 1） Scheduled：spring 3.0 后自带的定时器
 * 2） Quartz：定时器框架
 *
 * Created by wgh on 2021/3/16.
 */
@Component
public class Schedule {

    @Scheduled(fixedRate = 30000)//每30秒执行一次
    public void task() {
        System.out.println("Schedule启动定时任务:" + LocalDateTime.now());
    }
}