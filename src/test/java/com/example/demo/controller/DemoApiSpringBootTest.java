package com.example.demo.controller;

import com.example.demo.exception.DemoHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class DemoApiSpringBootTest {

    private MockMvc mockMvc;

    @Autowired
    private DemoApi demoApi;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(demoApi)
                .setControllerAdvice(new DemoHandler())
                .build();
    }

    @Test
    void isOK() throws Exception {
        // GIVEN
        DemoApiDto demoApiDto = DemoApiDto.builder()
                .demoName("hogeDemo")
                .demoObjectDto(
                        DemoObjectDto.builder()
                                .demoObjName("pugeObjName")
                                .build())
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String request = objectMapper.writeValueAsString(demoApiDto);

        // WHEN
        // THEN
        this.mockMvc
                .perform(get("/demoApi")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(request))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }
}
