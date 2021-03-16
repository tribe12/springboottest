package com.wgh.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 * 当我们需要对不同环境使用不同的 Bean 时，可以通过 @Profile 注解进行区分
 *
 *
 * Created by wgh on 2021/3/12.
 */
@Configuration
public class BeanConfiguration {

    @Bean
    @Profile("dev")
    public Runnable test1() {
        System.out.println("开发环境使用的 Bean");
        return () -> {};
    }

    @Bean
    @Profile("test")
    public Runnable test2() {
        System.out.println("测试环境使用的 Bean");
        return () -> {};
    }

    @Bean
    @Profile("pro")
    public Runnable test3() {
        System.out.println("生成环境使用的 Bean");
        return () -> {};
    }
}
