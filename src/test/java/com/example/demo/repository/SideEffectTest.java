package com.example.demo.repository;


import com.example.demo.entity.Address;
import com.example.demo.entity.City;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SideEffectTest {

    private AddressRepositoryImpl addressRepository;
    private AddressMapper addressMapper;

    @BeforeEach
    void setUp() {
        addressMapper = mock(AddressMapper.class);
        addressRepository = new AddressRepositoryImpl(
                addressMapper
        );
    }

    @Test
    void createSideEffectTest() {

        //GIVEN
        Address address = Address.builder()
                .address("Tokyo")
                .district("")
                .city(City.builder().cityId(90).build())
                .phone("000-1111-2222")
                .lastUpdate(Timestamp.valueOf(LocalDateTime.of(2019, 9, 9, 12, 12)))
                .build();

        when(addressMapper.create(any())).then(firstArgumentsSideEffect());

        //WHEN
        assertThat(address.getAddressId()).isEqualTo(0);
        int actual = addressRepository.create(address);

        //THEN
        assertThat(actual).isEqualTo(1);
        assertThat(address.getAddressId()).isEqualTo(1110);
    }


    @Test
    void createTest() {

        //GIVEN
        Address address = Address.builder()
                .address("Tokyo")
                .district("")
                .city(City.builder().cityId(90).build())
                .phone("000-1111-2222")
                .lastUpdate(Timestamp.valueOf(LocalDateTime.of(2019, 9, 9, 12, 12)))
                .build();

        when(addressMapper.create(any())).thenReturn(1);

        //WHEN
        int actual = addressRepository.create(address);

        //THEN
        assertThat(actual).isEqualTo(1);
    }


    private Answer<Integer> firstArgumentsSideEffect() {
        return invocation -> {
            Object[] args = invocation.getArguments();
            Address arg = (Address) args[0];
            arg.setAddressId(1110);
            return 1;
        };
    }

}
