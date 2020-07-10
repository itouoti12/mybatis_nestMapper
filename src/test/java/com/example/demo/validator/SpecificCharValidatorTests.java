package com.example.demo.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SpecificCharValidatorTests {

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @MethodSource("testStrList")
    @ParameterizedTest
    void specificCharTest(String targetStr, boolean expect) {
        TestBean testBean = new TestBean(targetStr);
        Set<ConstraintViolation<TestBean>> violations = validator.validate(testBean);
        assertThat(violations.isEmpty()).isEqualTo(expect);
    }

    static Stream<Arguments> testStrList() {
        return Stream.of(
                Arguments.arguments("", true),
                Arguments.arguments(null, true),
                Arguments.arguments("夏が近づき太平洋高気圧が勢力を増すようになると", true),
                Arguments.arguments("夏が近づき太平洋髙気圧が勢力を増すようになると", false),
                Arguments.arguments("髙等学校", false),
                Arguments.arguments("高等学校", true)
        );
    }

    private static class TestBean {
        @SpecificCharValid
        private String targetStr;

        TestBean(String targetStr) {
            this.targetStr = targetStr;
        }
    }

    @Disabled
    @Test
    void outputUnicode(){
        //検知対象にしたい文字をListに追加する。
        List<String> strList = List.of("髙", "あ", "い", "①");

        for(int i=0;i<strList.size(); i++){
            char[] charArray = strList.get(i).toCharArray();
            for (char c: charArray){
                System.out.println("SPECIFIC_CHAR_ENUM_"+
                        (i+1)+"(\""+strList.get(i)+"\",\""
                        +Integer.toHexString(c)+"\"),");
            }
        }
    }


}
