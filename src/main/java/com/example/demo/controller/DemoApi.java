package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

public interface DemoApi {

    @RequestMapping("/demoApi")
    ResponseEntity<DemoApiDto> get(DemoApiDto body);
}
