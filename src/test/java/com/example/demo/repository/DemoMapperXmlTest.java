package com.example.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Country;

@SpringBootTest
public class DemoMapperXmlTest {

    @Autowired
    DemoMapperXml target;
    
    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void wiringCountryXmlTest() {

        // action
        Country act = target.selctCountry(87);

        // assert
        assertThat(act).isNotNull();

    }
}
