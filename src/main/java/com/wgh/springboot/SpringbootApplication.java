package com.wgh.springboot;

/**
 * Created by wgh on 2021/3/12.
 */

import com.wgh.springboot.config.Cache;
import com.wgh.springboot.config.CacheConfirguration;
import com.wgh.springboot.config.DataSourceProperties;
import com.wgh.springboot.config.WebConfig;
import com.wgh.springboot.config.encoding.EncodingConvertor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Map;

/**
 该注解指定项目为springboot，由此类当作程序入口
 自动装配 web 依赖的环境

 **/
@EnableScheduling//开启都是任务
@Import(CacheConfirguration.class)
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);
        //测试属性装配
        System.out.println("测试属性装配:");
        context.getBean(WebConfig.class).show();
        //测试对象装配
        System.out.println("测试对象装配:");
        context.getBean(DataSourceProperties.class).show();

        //测试自动装配
        System.out.println("测试自动装配:");
        CacheConfirguration conf = context.getBean(CacheConfirguration.class);
        System.out.println(conf);
        Cache Cache = context.getBean(Cache.class);
        System.out.println(Cache);

        //测试条件配置
        System.out.println("测试条件配置:");
        Map<String, EncodingConvertor> map = context.getBeansOfType(EncodingConvertor.class);
        System.out.println(System.getProperty("file.encoding"));
        System.out.println(map);

    }
}
