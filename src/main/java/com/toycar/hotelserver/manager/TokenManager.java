package com.toycar.hotelserver.manager;


import com.toycar.hotelserver.bean.Token;
import com.toycar.hotelserver.pojo.Staff;
import com.toycar.hotelserver.pojo.User;

import java.util.Map;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;

public class TokenManager {

    private static Map<String, Token> tokenMap = new ConcurrentHashMap<>();

    private static Map<String,String> userTokenMap = new ConcurrentHashMap<>();


    public static String userLoginGetToken(User user){
        Token token = new Token(user);
        String userAccount = user.getUserAccount() + "-user";
        String oldToken = userTokenMap.get(userAccount);
        if (oldToken != null){
            releaseToken(oldToken);
        }
        userTokenMap.put(userAccount,token.getToken());
        tokenMap.put(token.getToken(),token);
        return token.getToken();
    }

    public static String staffLoginGetToken(Staff staff){
        Token token = new Token(staff);
        String staffAccount = staff.getStaffAccount() + "-staff";
        String oldToken = userTokenMap.get(staffAccount);
        if (oldToken != null){
            releaseToken(oldToken);
        }
        userTokenMap.put(staffAccount,token.getToken());
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
