package com.wgh.springboot.pay;

import java.math.BigDecimal;

/**
 * 支付策略
 * Created by wgh on 2021/5/3.
 */

public interface PayStrategy {
    /**
     * 获取最终价格
     *
     * @param goodsId
     * @param channelId
     * @return
     */
    public BigDecimal getPrice(Integer goodsId, Integer channelId);
}
