package com.example.demo.validator;

import lombok.extern.slf4j.Slf4j;

/**
 * 検知対象文字のEnum
 */
@Slf4j
public enum SpecificCharEnum {

    SPECIFIC_CHAR_ENUM_1("髙","9ad9");


    private final String specificChar;
    private final String unicodeStr;

    SpecificCharEnum(String specificChar, String unicodeStr) {
        this.specificChar = specificChar;
        this.unicodeStr = unicodeStr;
    }

    public String getUnicodeStr() {
        return unicodeStr;
    }

    public String getSpecificChar() {
        return specificChar;
    }

    public static boolean isSpecificChar(String targetUnicode){
        for (SpecificCharEnum specificCharEnum: SpecificCharEnum.values()){
            if (specificCharEnum.getUnicodeStr().equals(targetUnicode)){
                log.warn("検知対象の文字を検知しました。対象：{}",specificCharEnum.getSpecificChar());
                return true;
            }
        }
        return false;
    }
}
