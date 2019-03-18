package com.toycar.hotelserver.pojo;

public class VipType {
    private Integer vipType;

    private String vipDesc;

    public Integer getVipType() {
        return vipType;
    }

    public void setVipType(Integer vipType) {
        this.vipType = vipType;
    }

    public String getVipDesc() {
        return vipDesc;
    }

    public void setVipDesc(String vipDesc) {
        this.vipDesc = vipDesc == null ? null : vipDesc.trim();
    }
}