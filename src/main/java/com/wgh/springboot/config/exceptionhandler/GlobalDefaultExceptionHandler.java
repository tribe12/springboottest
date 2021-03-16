package com.wgh.springboot.config.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常捕获
 * <p>
 * (编写一个类充当全局异常的处理类，需要使用 @ControllerAdvice 和 @ExceptionHandler注解)
 * Created by wgh on 2021/3/15.
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    /**
     * 处理 Exception 类型的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Map<String, Object> defaultNullPointerExceptionExceptionHandler(Exception e) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 10086);
        map.put("msg", e.getMessage());
        return map;
    }
}