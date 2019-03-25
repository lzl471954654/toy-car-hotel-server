package com.toycar.hotelserver.manager;


import com.toycar.hotelserver.bean.Token;
import com.toycar.hotelserver.pojo.Staff;
import com.toycar.hotelserver.pojo.User;

import java.util.Map;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;

public class TokenManager {

    private static Map<String, Token> tokenMap = new ConcurrentHashMap<>();



    public static String userLoginGetToken(User user){
        Token token = new Token(user);
        tokenMap.put(token.getToken(),token);
        return token.getToken();
    }

    public static String staffLoginGetToken(Staff staff){
        Token token = new Token(staff);
        tokenMap.put(token.getToken(),token);
        return token.getToken();
    }

    public static boolean checkUserTokenValid(String token){
        Token t = tokenMap.get(token);
        if (t == null){
            return false;
        }
        if (t.isValid(token) && !t.isStaff()){
            return true;
        }else {
            //tokenMap.remove(token);
            return false;
        }
    }

    public static boolean checkStaffTokenValid(String token){
        Token t = tokenMap.get(token);
        if (t == null){
            return false;
        }
        if (t.isValid(token) && t.isStaff()){
            return true;
        }else {
            //tokenMap.remove(token);
            return false;
        }
    }

    public static void releaseToken(String token){
        tokenMap.remove(token);
    }

}
