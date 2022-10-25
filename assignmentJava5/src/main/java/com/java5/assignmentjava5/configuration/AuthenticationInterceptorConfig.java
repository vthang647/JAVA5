package com.java5.assignmentjava5.configuration;

import com.java5.assignmentjava5.interceptor.AdminAuthenticationInterceptor;
import com.java5.assignmentjava5.interceptor.CustomerAuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AuthenticationInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private AdminAuthenticationInterceptor adminAuthenticationInterceptor;

    @Autowired
    CustomerAuthenticationInterceptor customerAuthenticationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adminAuthenticationInterceptor).addPathPatterns("/admin/**");
        registry.addInterceptor(customerAuthenticationInterceptor).addPathPatterns("/list-giohang/**");
    }
}
