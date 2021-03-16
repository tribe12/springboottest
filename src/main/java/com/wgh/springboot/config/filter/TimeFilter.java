package com.wgh.springboot.config.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * 自定义时间过滤器
 * Created by wgh on 2021/3/15.
 */


//@Component
/*
    注册过滤器有两种方式：
    1、使用 @Component 注解
    2、添加到过滤器链中，此方式适用于使用第三方的过滤器。
        将过滤器写到 WebConfig 类中
 */
public class TimeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("=======初始化过滤器TimeFilter=========");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        long startTime = System.currentTimeMillis();
        filterChain.doFilter(request, response);
        System.out.println("filter 耗时：" + (System.currentTimeMillis() - startTime));
    }

    @Override
    public void destroy() {
        System.out.println("=======销毁过滤器TimeFilter=========");
    }

}
