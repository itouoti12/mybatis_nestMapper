package com.example.demo.repository;

import com.example.demo.entity.Address;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AddressMapper {
    int create(Address address);

    @Results(id = "AddressByDistinct",
            value = {
                    @Result(column = "address_id", property = "addressId"),
                    @Result(column = "address", property = "address"),
                    @Result(column = "address2", property = "address2"),
                    @Result(column = "district", property = "district"),
                    @Result(column = "city_id", property = "city.cityId"),
                    @Result(column = "postal_code", property = "postalCode"),
                    @Result(column = "phone", property = "phone"),
                    @Result(column = "last_update", property = "lastUpdate")
            })
    @Select("SELECT * FROM address WHERE district = #{district}")
    List<Address> getAddressByDistrict(@Param("district") String distinct);
}
