package com.example.demo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoApiController implements DemoApi {



    @Override
    public ResponseEntity<DemoApiDto> get(DemoApiDto body) {

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
