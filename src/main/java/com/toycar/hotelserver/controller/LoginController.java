package com.toycar.hotelserver.controller;

import com.toycar.hotelserver.pojo.Staff;
import com.toycar.hotelserver.pojo.User;
import com.toycar.hotelserver.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/hotel/login")
    public String login(User user){
        return loginService.login(user);
    }

    @RequestMapping("/hotel/register")
    public String register(User user){
        return loginService.register(user);
    }

    @RequestMapping("/hotel/staffLogin")
    public String staffLogin(Staff staff){
        return loginService.staffLogin(staff);
    }

}
