package com.toycar.hotelserver.pojo;

public class ExpType {
    private Integer expType;

    private String expDesc;

    public Integer getExpType() {
        return expType;
    }

    public void setExpType(Integer expType) {
        this.expType = expType;
    }

    public String getExpDesc() {
        return expDesc;
    }

    public void setExpDesc(String expDesc) {
        this.expDesc = expDesc == null ? null : expDesc.trim();
    }
}