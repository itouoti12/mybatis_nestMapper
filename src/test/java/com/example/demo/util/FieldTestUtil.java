package com.example.demo.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class FieldTestUtil {

    private final String className;
    private final String methodName;
    private String fieldName;
    private final Object baseFieldValue;
    private final Object compareTargetFieldValue;
    private final boolean result;

    public FieldTestUtil(
            String className,
            String methodName,
            String fieldName,
            Object baseFieldValue,
            Object compareTargetFieldValue,
            boolean result
    ) {
        this.className = className;
        this.methodName = methodName;
        this.fieldName = fieldName;
        this.baseFieldValue = baseFieldValue;
        this.compareTargetFieldValue = compareTargetFieldValue;
        this.result = result;
    }

    public void assertField() {

        try {
            Class<?> targetClass = Class.forName(className);
            Object baseObj = createObject(fieldName, baseFieldValue, targetClass);
            Object compareTarget = createObject(fieldName, compareTargetFieldValue, targetClass);

            Method method = targetClass.getMethod(methodName, targetClass);
            boolean actual = (boolean) method.invoke(baseObj, compareTarget);
            assertThat(actual).isEqualTo(result);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            fail("クラス名を確認してください。");
        } catch (InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException |
                NoSuchFieldException e) {
            e.printStackTrace();
            fail("メソッド名とフィールド名を確認してください。");
        }
    }

    private Object createObject(String fieldName, Object fieldValue, Class<?> targetClass)
            throws InstantiationException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException, NoSuchFieldException
    {
        Object obj = targetClass.getDeclaredConstructor().newInstance();
        Field objField = targetClass.getDeclaredField(fieldName);
        objField.setAccessible(true);
        objField.set(obj, fieldValue);
        return obj;
    }
}
