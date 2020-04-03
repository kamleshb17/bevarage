package com.study.bevarage.utility;

public class BevarageUtility {

    public static String getValue(final String value) {
        String subStringValue = value;
        if(subStringValue.contains("-")){
            subStringValue = subStringValue.replace("-", "").trim();
        }
        return subStringValue;
    }
}
