package com.example.demo.entity;

import java.sql.Timestamp;
import java.util.Objects;

import lombok.*;

@Builder
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

    public boolean isEqualEntity(Address target) {
        if (!Objects.equals(getAddressId(), target.getAddressId())) { return false; }
        if (!Objects.equals(getAddress(), target.getAddress())) { return false; }
        if (!Objects.equals(getAddress2(), target.getAddress2())) { return false; }
        if (!Objects.equals(getDistrict(), target.getDistrict())) { return false; }
        if (!Objects.equals(getPostalCode(), target.getPostalCode())) { return false; }
        if (!Objects.equals(getPhone(), target.getPhone())) { return false; }
        return Objects.equals(getLastUpdate(), target.getLastUpdate());
    }
}


