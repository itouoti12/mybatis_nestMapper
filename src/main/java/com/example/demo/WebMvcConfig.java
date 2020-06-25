package com.example.demo;

import com.example.demo.interceptor.HideHeader;
import com.example.demo.interceptor.HideHeaderInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Spring webMvc Configuration
 */

@Slf4j
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(hideHeaderInterceptor());
    }

    @Bean
    HideHeaderInterceptor hideHeaderInterceptor() {
        return new HideHeaderInterceptor(hideHeader());
    }

    @Bean
//    @Scope("request")
    @Scope(value = WebApplicationContext.SCOPE_REQUEST,proxyMode = ScopedProxyMode.TARGET_CLASS)
    HideHeader hideHeader() {
        return new HideHeader();
    }
}
