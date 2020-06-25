package com.example.demo.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DemoComponentImpl implements DemoComponent {
    @Override
    public int timesCalculation(int target, int times) {
        return target * times;
    }
}
