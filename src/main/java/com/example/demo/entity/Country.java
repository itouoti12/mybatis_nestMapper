package com.example.demo.entity;

import java.sql.Timestamp;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    private int countryId;

    private String country;

    private Timestamp lastUpdate;

    private Set<City> city;
}
