package com.wgh.springboot.service.impl;

import com.wgh.springboot.pay.PayStrategy;
import com.wgh.springboot.pay.PayStrategyFactory;
import com.wgh.springboot.service.PayService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by wgh on 2021/5/3.
 */
@Service
public class PayServiceImpl implements PayService {



    @Override
    public BigDecimal getPrice(Integer goodsId, Integer channelId) {
        PayStrategyFactory factory = PayStrategyFactory.getInstance();
        PayStrategy payStrategy = factory.getPayStrategy(channelId);
        return payStrategy.getPrice(goodsId, channelId);
    }
}
