package com.toycar.hotelserver.pojo;

import java.util.Date;

public class Expenditure {
    private String expId;

    private Date expDate;

    private Long expPrice;

    private Integer expType;

    public String getExpId() {
        return expId;
    }

    public void setExpId(String expId) {
        this.expId = expId == null ? null : expId.trim();
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public Long getExpPrice() {
        return expPrice;
    }

    public void setExpPrice(Long expPrice) {
        this.expPrice = expPrice;
    }

    public Integer getExpType() {
        return expType;
    }

    public void setExpType(Integer expType) {
        this.expType = expType;
    }
}