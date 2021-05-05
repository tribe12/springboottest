package com.wgh.springboot.controller;

import com.wgh.springboot.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by wgh on 2021/5/3.
 */

@RestController
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private PayService payService;

    @GetMapping("/getprice")
    public String getPrice(Integer goodsId, Integer channelId) {
        System.out.println("/pay/getprice");
        BigDecimal price = payService.getPrice(goodsId, channelId);
        String res = "goodsId: " + goodsId + ", channelId: " + channelId + ", 最终价格：" + price.doubleValue();
        System.out.println(res);
        return res;
    }

}
