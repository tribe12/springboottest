package com.wgh.springboot.pay.impl;

import com.wgh.springboot.bean.Goods;
import com.wgh.springboot.bean.PayChannel;
import com.wgh.springboot.mapper.GoodsMapper;
import com.wgh.springboot.mapper.PayChannelMapper;
import com.wgh.springboot.pay.Pay;
import com.wgh.springboot.pay.PayStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * Created by wgh on 2021/5/3.
 */
@Pay(1)
public class ICBCPay implements PayStrategy {

    @Autowired
    private PayChannelMapper payChannelMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public BigDecimal getPrice(Integer goodsId, Integer channelId) {

        Goods goods = goodsMapper.getGoods(goodsId);
        PayChannel payChannel = payChannelMapper.getPayChannel(channelId);
        //工商银行特有逻辑
        //.......
        if (goods != null && payChannel != null) {
            return goods.getPrice().multiply(payChannel.getDiscount());
        }
        return null;
    }
}
