package com.wgh.springboot.pay;

import java.math.BigDecimal;

/**
 * Created by wgh on 2021/5/3.
 */
public class PayContext {
    private PayStrategy payStrategy;

    public BigDecimal getPrice(Integer goodsId, Integer channelId) {
        PayStrategyFactory payStrategyFactory = PayStrategyFactory.getInstance();

        payStrategy = payStrategyFactory.creatPayStrategy(channelId);


        return this.payStrategy.getPrice(goodsId, channelId);
    }
}
