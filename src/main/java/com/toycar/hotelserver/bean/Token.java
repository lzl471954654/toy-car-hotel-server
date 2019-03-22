package com.toycar.hotelserver.bean;

import com.toycar.hotelserver.pojo.Staff;
import com.toycar.hotelserver.pojo.User;
import org.apache.commons.codec.digest.DigestUtils;

public class Token {

    private static final long TIME_MAX = 30 * 60 * 1000L;

    private String token;
    private long lastTime;
    private User user;
    private Staff staff;

    public Token(User user) {
        this.user = user;
        this.lastTime = System.currentTimeMillis();
        generateTokenByUser();
    }

    public Token(Staff staff){
        this.staff = staff;
        this.lastTime = System.currentTimeMillis();
        generateTokenByStaff();
    }

    private void generateTokenByStaff(){
        String message = staff.getStaffAccount()
                + staff.getStaffName()
                + staff.getStaffDept()
                + staff.getStaffPhone()
                + staff.getStaffPermission()
                + staff.getStaffSalary()
                + staff.getStaffPass()
                + "toyCar";
        token = DigestUtils.sha1Hex(message);
    }



    private void generateTokenByUser(){
        String message = user.getUserAccount()
                + user.getUserNickname()
                + user.getUserPhone()
                + user.getUserVip()
                + user.getUserPass()
                + "toyCar";
        token = DigestUtils.sha1Hex(message);
    }

    public boolean isValid(String token){
        long temp = lastTime;
        lastTime = System.currentTimeMillis();
        return token.equals(this.token) && (lastTime - temp < TIME_MAX);
    }

    public boolean isStaff(){
        return staff != null && user == null;
    }

    public String getToken() {
        return token;
    }

    public User getUser() {
        return user;
    }

    public Staff getStaff() {
        return staff;
    }
}
