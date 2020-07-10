package com.example.demo.entity;

import com.example.demo.util.FieldTestUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AddressTests {

    @Test
    void testPattern1() {
        Address base = Address.builder().addressId(1).build();
        Address target = Address.builder().addressId(1).build();
        boolean actual = base.equals(target);
        assertThat(actual).isTrue();

        base = Address.builder().addressId(1).build();
        target = Address.builder().addressId(5).build();
        actual = base.equals(target);
        assertThat(actual).isFalse();

        // success
        base = Address.builder().addressId(1).city(City.builder().build()).build();
        target = Address.builder().addressId(1).city(City.builder().city("Tokyo").build()).build();
        actual = base.equals(target);
        assertThat(actual).isTrue();
    }

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    void compareTest(String fieldName, Object baseValue, Object compareValue, boolean result) {
        String className = "com.example.demo.entity.Address";
        String methodName = "isEqualEntity";

        new FieldTestUtil(className, methodName, fieldName, baseValue, compareValue, result)
                .assertField();
    }

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                Arguments.arguments("city", null, null, true),
                Arguments.arguments("city", City.builder().build(), City.builder().build(), true),
                Arguments.arguments("city", City.builder().build(), City.builder().cityId(4).build(), true),
                Arguments.arguments("addressId", 1, 1, true),
                Arguments.arguments("addressId", 1, 2, false),
                Arguments.arguments("address", null, null, true),
                Arguments.arguments("address", "tokyo", "tokyo", true),
                Arguments.arguments("address", "tokyo", "osaka", false)
        );
    }

}