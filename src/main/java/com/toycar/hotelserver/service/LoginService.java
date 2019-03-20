package com.toycar.hotelserver.service;

import com.google.gson.JsonObject;
import com.toycar.hotelserver.manager.TokenManager;
import com.toycar.hotelserver.mapper.UserMapper;
import com.toycar.hotelserver.pojo.User;
import com.toycar.hotelserver.util.JSONUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired(required = false)
    private UserMapper userMapper;

    public String register(User user){
        int code;
        User s = userMapper.selectByPrimaryKey(user.getUserAccount());
        if ( s != null){
            code = -1;
        }else {
            user.setUserVip( user.getUserVip() == null ? 1 : user.getUserVip() );
            code = userMapper.insert(user);
        }
        user.setUserPass("");
        String token = "";
        if (code == 1){
            token = TokenManager.userLoginGetToken(user);
        }
        JsonObject object = JSONUtil.generateJsonWithToken(code,user,token);
        return object.toString();
    }

    public String login(User user){
        int code;
        User selectUser = userMapper.selectByPrimaryKey(user.getUserAccount());
        if (selectUser == null){
            code = -1;
        }else if (!selectUser.getUserPass().equals(user.getUserPass())){
            code = 0;
        }else {
            code = 1;
        }
        user.setUserPass("");
        String token = "";
        if (code == 1){
            token = TokenManager.userLoginGetToken(user);
            user.setUserVip(selectUser.getUserVip());
            user.setUserNickname(selectUser.getUserNickname());
        }
        JsonObject object = JSONUtil.generateJsonWithToken(code,user,token);
        return object.toString();
    }

}
