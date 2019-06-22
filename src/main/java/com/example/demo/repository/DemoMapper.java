package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.example.demo.entity.Address;
import com.example.demo.entity.City;
import com.example.demo.entity.Country;
import com.example.demo.entity.CountryId;

@Mapper
public interface DemoMapper {
    
    @Results(id = "Country", value = {
            @Result(column = "country", property = "country"),
            @Result(column = "last_update", property = "lastUpdate"),
            
            @Result(column = "country_id", property = "id",
            one = @One(select = "selectCountryId")),
            
            @Result(column = "country_id", property = "city", 
            many = @Many(select = "selectCity"))
            //遅延読み込みを有効にする
            //many = @Many(select = "selctCity", fetchType = FetchType.LAZY))
    })
    @Select("SELECT * FROM country WHERE country_id = #{id}")
    Country selectCountry(@Param("id")Integer id);
    
    @Results(id = "CountryId", value = {
            @Result(column = "country_id", property = "countryId")
    })
    @Select("SELECT * FROM country WHERE country_id = #{id}")
    CountryId selectCountryId(Integer id);
    
    
    @Results(id = "City", value = {
            @Result(column = "city_id", property = "cityId"),
            @Result(column = "city", property = "city"),
            @Result(column = "last_update", property = "lastUpdate"),
            
            @Result(column = "city_id", property = "address", 
            many = @Many(select = "selectAddress"))
    })
    @Select("SELECT * FROM city WHERE country_id = #{id}")
    City selectCity(Integer id);
    
    
    
    @Results(id = "Address", value = {
            @Result(column = "address_id", property = "addressId"),
            @Result(column = "address", property = "address"),
            @Result(column = "address2", property = "address2"),
            @Result(column = "district", property = "district"),
            @Result(column = "postal_code", property = "postalCode"),
            @Result(column = "phone", property = "phone"),
            @Result(column = "last_update", property = "lastUpdate"),
            
    })
    @Select("SELECT * FROM address WHERE city_id = #{id}")
    Address selectAddress(Integer id);

}
