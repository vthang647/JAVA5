package com.java5.assignmentjava5.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class AdminAuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("pre handle of request" + request.getRequestURI());
        if(session.getAttribute("username") != null){
            return true;
        }

        if (!request.getRequestURI().endsWith("/admin/login") ) {
            session.setAttribute("redirect-uri", request.getRequestURI());
            response.sendRedirect("/admin/login");
            return false;
        }
        return true;
    }
}
