package com.wgh.springboot.config;

import org.springframework.context.annotation.Bean;

/**
 * Created by wgh on 2021/3/15.
 */
//@Configuration
public class CacheConfirguration {

    @Bean
    public Cache createCacheObj() {
        return new Cache();
    }
}