package com.wgh.springboot.config.encoding;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * （当我们需要根据系统环境的字符集选择性的装配其中一个 Bean 时，
 *   需要结合 @Conditional 注解 和 Condition 接口使用）
 * Created by wgh on 2021/3/15.
 */
public class GBKCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String encoding = System.getProperty("file.encoding");
        if (encoding != null) {
            return "gbk".equals(encoding.toLowerCase());
        }
        return false;
    }

}