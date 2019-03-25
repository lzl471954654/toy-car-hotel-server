package com.toycar.hotelserver.interceptor;

import com.toycar.hotelserver.exception.AccessDenyException;
import com.toycar.hotelserver.manager.TokenManager;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonAccessInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getParameter("token");
        if (token == null){
            throw new AccessDenyException("Permission Denied");
        }
        if (TokenManager.checkUserTokenValid(token) || TokenManager.checkStaffTokenValid(token)){
            return true;
        }
        throw new AccessDenyException("Permission Denied ["+this.getClass().getName()+"]");
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
