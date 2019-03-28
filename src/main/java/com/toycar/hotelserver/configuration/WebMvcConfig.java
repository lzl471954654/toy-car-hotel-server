package com.toycar.hotelserver.configuration;
import com.toycar.hotelserver.interceptor.CommonAccessInterceptor;
import com.toycar.hotelserver.interceptor.StaffAccessIntercept;
import com.toycar.hotelserver.interceptor.UserAccessInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] commonEx = {"/hotel/login","/hotel/staffLogin","/hotel/register"};
        registry.addInterceptor(new StaffAccessIntercept()).addPathPatterns("/hotel/staff/**");
        registry.addInterceptor(new UserAccessInterceptor()).addPathPatterns("/hotel/user/**");
        registry.addInterceptor(new CommonAccessInterceptor()).addPathPatterns("/hotel/**").excludePathPatterns(commonEx);
    }
}
