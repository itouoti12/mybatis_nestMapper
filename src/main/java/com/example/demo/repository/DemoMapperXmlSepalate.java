package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Country;

@Mapper
public interface DemoMapperXmlSepalate {

    Country selectCountry(@Param("id")Integer id);
    
}
