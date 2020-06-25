package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig(classes = DemoServiceDISpringJunitConfigTest.Config.class)
public class DemoServiceDISpringJunitConfigTest {

    @Autowired
    private DemoService target;

    @ComponentScan({
            "com.example.demo.service",
            "com.example.demo.component"
    })
    static class Config {
    }

    @Test
    void triangleAreaTimesHeightByCalculationTest() {

        //GIVEN
        int base = 6;
        int height = 3;
        int times = 2;
        int excepted = 36;

        //WHEN
        int actual = target.triangleAreaTimesHeightByCalculation(base, height, times);

        //THEN
        assertThat(actual).isEqualTo(excepted);
    }
}
