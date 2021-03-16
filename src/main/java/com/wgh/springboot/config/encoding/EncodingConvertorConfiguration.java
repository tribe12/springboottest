package com.wgh.springboot.config.encoding;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * （当我们需要根据系统环境的字符集选择性的装配其中一个 Bean 时，
 *   需要结合 @Conditional 注解 和 Condition 接口使用）
 * Created by wgh on 2021/3/15.
 */
@Configuration
public class EncodingConvertorConfiguration {

    @Bean
    @Conditional(UTF8Condition.class)
    public EncodingConvertor createUTF8EncodingConvertor() {
        return new UTF8EncodingConvertor();
    }

    @Bean
    @Conditional(GBKCondition.class)
    public EncodingConvertor createGBKEncodingConvertor() {
        return new GBKEncodingConvertor();
    }
}