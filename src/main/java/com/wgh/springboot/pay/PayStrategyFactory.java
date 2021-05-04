package com.wgh.springboot.pay;

import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by wgh on 2021/5/3.
 */
public class PayStrategyFactory {
    private static PayStrategyFactory factory = new PayStrategyFactory();
    private static Map<Integer, String> payStrategyMap = new HashMap<>();

    /**
     * 根据扫描指定路径下的类的注解，放置payStrategyMap中。
     */
    static {
        Reflections reflections = new Reflections("com.wgh.springboot.pay.impl");
        Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(Pay.class);
        for (Class clazz : classSet) {
            Pay pay = (Pay) clazz.getAnnotation(Pay.class);
            payStrategyMap.put(pay.value(), clazz.getCanonicalName());
        }
    }

    private PayStrategyFactory() {
    }

    public static PayStrategyFactory getInstance() {
        return factory;
    }

    public PayStrategy creatPayStrategy(Integer channelId){
        String clazz = payStrategyMap.get(channelId);
        PayStrategy payStrategy = null;
        try {
            Class ps = Class.forName(clazz);
            try {
                payStrategy = (PayStrategy)ps.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return payStrategy;
    }
}
