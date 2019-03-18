package com.toycar.hotelserver.pojo;

import java.util.Date;

public class Income {
    private String orderId;

    private Integer orderType;

    private Long incomePrice;

    private Date incomeDate;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Long getIncomePrice() {
        return incomePrice;
    }

    public void setIncomePrice(Long incomePrice) {
        this.incomePrice = incomePrice;
    }

    public Date getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(Date incomeDate) {
        this.incomeDate = incomeDate;
    }
}