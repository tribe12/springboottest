package com.wgh.springboot.pay;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wgh on 2021/5/3.
 */
public class PayStrategyFactory {
    private static PayStrategyFactory factory = new PayStrategyFactory();
    private static Map<Integer, PayStrategy> payStrategyMap = new HashMap<>();

    private PayStrategyFactory() {
    }

    public static PayStrategyFactory getInstance() {
        return factory;
    }

    public static void register(Integer channelId, PayStrategy payStrategy) {
        System.out.println("========== register ===========");
        System.out.println("channelId: "+channelId);
        System.out.println("payStrategy: "+payStrategy);
        payStrategyMap.put(channelId, payStrategy);
    }

    public PayStrategy getPayStrategy(Integer channelId) {
        return payStrategyMap.get(channelId);
    }
}
