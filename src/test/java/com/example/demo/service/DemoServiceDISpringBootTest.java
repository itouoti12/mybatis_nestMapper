package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DemoServiceDISpringBootTest {

    @Autowired
    private DemoService target;

    @Test
    void triangleAreaTimesHeightByCalculationTest(){

        //GIVEN
        int base = 6;
        int height = 3;
        int times = 2;
        int excepted = 36;

        //WHEN
        int actual = target.triangleAreaTimesHeightByCalculation(base, height,times);

        //THEN
        assertThat(actual).isEqualTo(excepted);
    }
}
