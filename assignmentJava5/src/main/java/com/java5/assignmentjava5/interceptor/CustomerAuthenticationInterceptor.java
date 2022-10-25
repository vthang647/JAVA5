package com.java5.assignmentjava5.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class CustomerAuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("pre customer uri: "+ request.getRequestURI());
        if (session.getAttribute("customer") != null){
            return true;
        }

        if (!request.getRequestURI().endsWith("/customer/login")){
            session.setAttribute("redirect-uri-cus", request.getRequestURI());
            response.sendRedirect("/customer/login");
            return false;
        }
        return false;
    }
}
