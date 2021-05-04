package com.wgh.springboot.controller;

import com.wgh.springboot.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/getprice")
    public BigDecimal getPrice(Integer goodsId, Integer channelId) {
        System.out.println("/pay/getprice");
        return payService.getPrice(goodsId, channelId);
    }

}
