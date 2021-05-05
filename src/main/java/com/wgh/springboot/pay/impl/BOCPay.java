package com.wgh.springboot.pay.impl;

import com.wgh.springboot.bean.Goods;
import com.wgh.springboot.bean.PayChannel;
import com.wgh.springboot.mapper.GoodsMapper;
import com.wgh.springboot.mapper.PayChannelMapper;
import com.wgh.springboot.pay.PayStrategy;
import com.wgh.springboot.pay.PayStrategyFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * BOC的支付策略
 * <p>
 * 这里借用Spring中提供的InitializingBean接口，
 * 这个接口为Bean提供了属性初始化后的处理方法，
 * 但凡实现InitializingBean接口的类，
 * 在bean初始化后都会执行afterPropertiesSet()方法。
 * <p>
 * Created by wgh on 2021/5/3.
 */
@Service
public class BOCPay implements PayStrategy, InitializingBean {

    @Autowired
    private PayChannelMapper payChannelMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public BigDecimal getPrice(Integer goodsId, Integer channelId) {

        Goods goods = goodsMapper.getGoods(goodsId);
        PayChannel payChannel = payChannelMapper.getPayChannel(channelId);
        //中国银行特有逻辑
        //.......
        if (goods != null && payChannel != null) {
            return goods.getPrice().multiply(payChannel.getDiscount());
        }
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(" BOCPay.afterPropertiesSet()");
        PayStrategyFactory.getInstance().register(3, this);
    }
}
