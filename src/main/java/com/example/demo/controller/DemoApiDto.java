package com.example.demo.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DemoApiDto {

    @JsonProperty("demoName")
    String demoName;

    @JsonProperty("demoObjectDto")
    DemoObjectDto demoObjectDto;
}
