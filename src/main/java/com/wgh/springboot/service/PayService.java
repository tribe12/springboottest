package com.wgh.springboot.service;

import java.math.BigDecimal;

/**
 * Created by wgh on 2021/5/3.
 */
public interface PayService {
    BigDecimal getPrice(Integer goodsId, Integer channelId);
}
