package com.wgh.springboot.utils;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Set;

/**
 * Created by wgh on 2021/5/5.
 */
public class BeanUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public BeanUtils() {
        //加载继承该类的类，扫描成员变量
        Reflections reflections = new Reflections(this.getClass(), new FieldAnnotationsScanner());
        //将所有含有Resource注解的成员变量扫描出来
        Set<Field> fieldSet = reflections.getFieldsAnnotatedWith(Resource.class);

        for (Field f : fieldSet) {
            //获取成员变量类名
            String simpleName = f.getType().getSimpleName();
            //因为spring管理的bean的name都是首字母小写的

            Object bean = applicationContext.getBean(simpleName);
            if (bean == null) {
                return;
            }
            //我们必须要打破封装
            f.setAccessible(true);
            //把spring管理的对象，设置到我们反射出来的对象中
            try {
                f.set(this, bean);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }
}
