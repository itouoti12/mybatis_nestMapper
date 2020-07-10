package com.example.demo.validator;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class SpecificCharValidator implements ConstraintValidator<SpecificCharValid, String> {

    @Override
    public void initialize(SpecificCharValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        char[] chars = value.toCharArray();
        for (char c : chars) {
            String unicodeStr = Integer.toHexString(c);
            if (SpecificCharEnum.isSpecificChar(unicodeStr)) {
                String targetStr = ((ConstraintValidatorContextImpl) context)
                        .getConstraintViolationCreationContexts().get(0).getPath().toString();
                log.warn("検知対象の文字が含まれています。対象項目：{} 値：「{}」", targetStr, value);
                return false;
            }
        }
        return true;
    }
}
