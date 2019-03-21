package com.toycar.hotelserver;

import com.toycar.hotelserver.intercept.LoginIntercept;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] excludePath = {"/Login","/register"};
        registry.addInterceptor(new LoginIntercept()).addPathPatterns("/**").excludePathPatterns(excludePath);
    }
}
