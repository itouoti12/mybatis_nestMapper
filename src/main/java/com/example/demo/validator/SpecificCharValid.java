package com.example.demo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 文字列の中に、特定の文字が含まれていた場合はバリデーションエラーを返すAnnotation <br>
 * どの文字が対象となるかは{@link SpecificCharEnum}参照
 */
@Documented
@Constraint(validatedBy = {SpecificCharValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SpecificCharValid {

    String message() default "The characters that cannot be used are included.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        SpecificCharValid[] value();
    }
}
