package com.example.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Country;

@SpringBootTest
public class DemoMapperXmlSepaleteTest {

    @Autowired
    DemoMapperXmlSepalate target;

    @Test
    void wiringCountryXmlTest() {

        // action
        Country act = target.selectCountry(87);

        // assert
        assertThat(act).isNotNull();

    }
}
