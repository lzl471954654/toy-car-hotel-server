package com.toycar.hotelserver.manager;


import com.toycar.hotelserver.bean.Token;
import com.toycar.hotelserver.pojo.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenManager {

    private static Map<String, Token> tokenMap = new ConcurrentHashMap<>();

    public static String userLoginGetToken(User user){
        Token token = new Token(user);
        tokenMap.put(token.getToken(),token);
        return token.getToken();
    }

    private static boolean checkTokenValid(String token){
        Token t = tokenMap.get(token);
        if (t == null){
            return false;
        }
        if (t.isValid(token)){
            return true;
        }else {
            tokenMap.remove(token);
            return false;
        }
    }

}
