package com.example.demo.service;

import com.example.demo.component.DemoComponentImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DemoServiceTest {

    private DemoService target;

    @BeforeEach
    void setUp() {
        target = new DemoService(new DemoComponentImpl());
    }

    @Test
    void normalTest() {
        //GIVEN
        int base = 6;
        int height = 3;
        int excepted = 9;

        //WHEN
        int actual = target.calculateTriangleArea(base, height);

        //THEN
        assertThat(actual).isEqualTo(excepted);
    }

    @Test
    void dataPatternTest() {
        //GIVEN
        for (DataPattern param : List.of(
                new DataPattern(6, 3, 9),
                new DataPattern(9, 4, 18),
                new DataPattern(7, 4, 14)
        )) {
            //WHEN
            int actual = target.calculateTriangleArea(param.base, param.height);

            //THEN
            assertThat(actual).isEqualTo(param.excepted);
        }
    }

    class DataPattern {
        int base;
        int height;
        int excepted;

        DataPattern(int base, int height, int excepted) {
            this.base = base;
            this.height = height;
            this.excepted = excepted;
        }
    }


    @ParameterizedTest
    @ArgumentsSource(ArgumentsParameterTest.class)
    void ArgumentsParameterTest(ArgumentsParameterTest args) {

        //WHEN
        int actual = target.calculateTriangleArea(args.base, args.height);

        //THEN
        assertThat(actual).isEqualTo(args.expected);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class ArgumentsParameterTest implements ArgumentsProvider {
        int base;
        int height;
        int expected;

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(
                    Arguments.of(new ArgumentsParameterTest(6, 2, 6)),
                    Arguments.of(new ArgumentsParameterTest(9, 4, 18)),
                    Arguments.of(new ArgumentsParameterTest(7, 4, 14))
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(ArgumentsParameterTestBuilder.class)
    void ArgumentsParameterTestBuilder(ArgumentsParameterTestBuilder args) {

        //WHEN
        int actual = target.calculateTriangleArea(args.base, args.height);

        //THEN
        assertThat(actual).isEqualTo(args.expected);
    }

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class ArgumentsParameterTestBuilder implements ArgumentsProvider {
        int base;
        int height;
        int expected;

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(
                    Arguments.of(ArgumentsParameterTestBuilder.builder().base(6).height(2).expected(6).build()),
                    Arguments.of(ArgumentsParameterTestBuilder.builder().base(9).height(4).expected(18).build()),
                    Arguments.of(ArgumentsParameterTestBuilder.builder().base(7).height(4).expected(14).build())
            );
        }
    }

    @ParameterizedTest
    @MethodSource("methodParameter")
    void methodParameterTest(int base, int height, int expected) {

        //WHEN
        int actual = target.calculateTriangleArea(base, height);

        //THEN
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> methodParameter() {
        return Stream.of(
                Arguments.of(6, 2, 6),
                Arguments.of(9, 4, 18),
                Arguments.of(7, 4, 14)
        );
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class nested {

        @ParameterizedTest
        @MethodSource("methodParameterNest")
        void methodParameterTestNested(int base, int height, int expected) {

            //WHEN
            int actual = target.calculateTriangleArea(base, height);

            //THEN
            assertThat(actual).isEqualTo(expected);
        }

        Stream<Arguments> methodParameterNest() {
            return Stream.of(
                    Arguments.of(6, 2, 6),
                    Arguments.of(9, 4, 18),
                    Arguments.of(7, 4, 14)
            );
        }
    }

    @ParameterizedTest
    @CsvSource({
            "6,2,6",
            "9,4,18",
            "7,4,14"
    })
    void CsvParameterTest(int base, int height, int expected) {

        //WHEN
        int actual = target.calculateTriangleArea(base, height);

        //THEN
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 6})
    void ValueParameterTestValue(int height) {

        //WHEN
        boolean actual = target.validation(height);

        //THEN
        assertThat(actual).isFalse();
    }


}
