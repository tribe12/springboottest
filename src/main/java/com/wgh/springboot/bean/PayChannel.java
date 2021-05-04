package com.wgh.springboot.bean;

import java.math.BigDecimal;

/**
 * Created by wgh on 2021/5/4.
 */
public class PayChannel {
    private Integer channelId;
    private String channelName;
    private BigDecimal discount;
    private int position;
    private double correct;
    private String code;
    private int status;

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public double getCorrect() {
        return correct;
    }

    public void setCorrect(double correct) {
        this.correct = correct;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
