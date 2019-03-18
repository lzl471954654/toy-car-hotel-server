package com.toycar.hotelserver.pojo;

public class Staff {
    private String staffAccount;

    private String staffName;

    private String staffPhone;

    private Integer staffPermission;

    private String staffDept;

    private String staffPass;

    private Integer staffSalary;

    public String getStaffAccount() {
        return staffAccount;
    }

    public void setStaffAccount(String staffAccount) {
        this.staffAccount = staffAccount == null ? null : staffAccount.trim();
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone == null ? null : staffPhone.trim();
    }

    public Integer getStaffPermission() {
        return staffPermission;
    }

    public void setStaffPermission(Integer staffPermission) {
        this.staffPermission = staffPermission;
    }

    public String getStaffDept() {
        return staffDept;
    }

    public void setStaffDept(String staffDept) {
        this.staffDept = staffDept == null ? null : staffDept.trim();
    }

    public String getStaffPass() {
        return staffPass;
    }

    public void setStaffPass(String staffPass) {
        this.staffPass = staffPass == null ? null : staffPass.trim();
    }

    public Integer getStaffSalary() {
        return staffSalary;
    }

    public void setStaffSalary(Integer staffSalary) {
        this.staffSalary = staffSalary;
    }
}