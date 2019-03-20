package com.toycar.hotelserver.bean;

import com.toycar.hotelserver.pojo.User;
import org.apache.commons.codec.digest.DigestUtils;

public class Token {

    private static final long TIME_MAX = 30 * 60 * 1000L;

    private String token;
    private long lastTime;
    private User user;

    public Token(User user) {
        this.user = user;
        this.lastTime = System.currentTimeMillis();
        generateToken();
    }



    private void generateToken(){
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

    public String getToken() {
        return token;
    }
}
