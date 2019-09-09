package com.example.demo.repository;

import com.example.demo.entity.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AddressRepositoryImpl implements AddressRepository {

    private final AddressMapper addressMapper;

    public int create(Address address) {
        return addressMapper.create(address);
    }
}
