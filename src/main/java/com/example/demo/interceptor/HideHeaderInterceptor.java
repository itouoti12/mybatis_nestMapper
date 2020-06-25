package com.example.demo.interceptor;

import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
public class HideHeaderInterceptor  extends HandlerInterceptorAdapter {

    private final HideHeader hideHeader;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String headerValue = request.getHeader("hide-header");
        if(headerValue != null){
            hideHeader.setHideHeaderValue(headerValue);
        }
        return true;
    }
}
