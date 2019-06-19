package com.example.demo.entity;

import java.sql.Timestamp;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

    private int cityId;

    private String city;

    private Country country;

    private Timestamp lastUpdate;

    private Set<Address> address;

}
