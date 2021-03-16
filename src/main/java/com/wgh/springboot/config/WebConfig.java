package com.wgh.springboot.config;

import com.wgh.springboot.config.filter.TimeFilter;
import com.wgh.springboot.config.interceptor.TimeInterceptor;
import com.wgh.springboot.config.listener.ListenerTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * （属性装配）有两种方式：使用 @Value 注解和 Environment 对象。
 * Created by wgh on 2021/3/13.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    //通过@Value获取config.userName配置；
    @Value("${ds.userName}")
    private String userName;


    @Autowired
    private Environment environment;

    @Autowired
    private TimeInterceptor timeInterceptor;

    public WebConfig() {
    }

    public void show() {
        System.out.println("======== WebConfig.show(): ========");
        System.out.println("ds.userName:" + this.userName);
        //通过environment获取config.password配置。
        System.out.println("ds.password:" + this.environment.getProperty("ds.password"));
        //也可以通过environment获取config.userName和ds.url等。
        System.out.println("ds.userName:" + this.environment.getProperty("ds.userName"));
        System.out.println("ds.url:" + this.environment.getProperty("ds.url"));
    }


    /**
    注册过滤器有两种方式：
    1、使用 @Component 注解
    2、添加到过滤器链中，此方式适用于使用第三方的过滤器。
        将过滤器写到 WebConfig 类中
    */
    @Bean
    public FilterRegistrationBean timeFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        TimeFilter timeFilter = new TimeFilter();
        registrationBean.setFilter(timeFilter);

        List<String> urls = new ArrayList<>();
        urls.add("/*");
        registrationBean.setUrlPatterns(urls);

        return registrationBean;
    }


    /**
     * 注册监听器为 Bean
     *
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean<ListenerTest> servletListenerRegistrationBean() {
        return new ServletListenerRegistrationBean<ListenerTest>(new ListenerTest());
    }


    /**
     * 将拦截器注册到拦截器链中
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }

}