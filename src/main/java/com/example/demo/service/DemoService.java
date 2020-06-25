package com.example.demo.service;

import com.example.demo.component.DemoComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class DemoService {

    private  final DemoComponent demoComponent;

    int calculateTriangleArea(int base, int height) {
        return (base * height) / 2;
    }

    boolean validation(int height){
        return height == 3 || height == 5;
    }

    int triangleAreaTimesHeightByCalculation(int base, int height, int times){

        int timesHeight = demoComponent.timesCalculation(height,times);

        return base * timesHeight;
    }
}
