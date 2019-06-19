package com.example.demo.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private int addressId;

    private String address;

    private String address2;

    private String district;

    private City city;

    private String postalCode;

    private String phone;

    private Timestamp lastUpdate;

}
