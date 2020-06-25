package com.example.demo;

import com.example.demo.interceptor.HideHeaderInterceptor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class WebMvcConfigTests {

    @Test
    void addInterceptors() {
        InterceptorRegistry mock = Mockito.mock(InterceptorRegistry.class);
        WebMvcConfig target = new WebMvcConfig();

        target.addInterceptors(mock);

        verify(mock).addInterceptor(any(HideHeaderInterceptor.class));
    }
}
