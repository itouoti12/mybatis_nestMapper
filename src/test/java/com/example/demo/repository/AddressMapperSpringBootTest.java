package com.example.demo.repository;

import com.example.demo.entity.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AddressMapperSpringBootTest {

    @Autowired
    private AddressMapper addressMapper;

    @Test
    void assertionTest() {

        //GIVEN
        String distinct = "Bihar";

        //WHEN
        List<Address> actual = addressMapper.getAddressByDistrict(distinct);

        //THEN
        //フィールドの値が全てNullではない
        assertThat(actual).extracting("address").allMatch(Objects::nonNull);
        //フィールドの値が全て空文字
        assertThat(actual).extracting("address2").allMatch(i -> "".equals(i));
        //フィールドの値が全てリストで指定した値
        assertThat(actual).extracting("city.cityId").allMatch(
                i -> List.of(264, 110, 346).contains(i));
    }
}
