package com.ntt.data.project.application.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PanMasker {

    public static String mask(String pan) {
        StringBuilder maskedString = new StringBuilder(pan);
        int startIndex = 4;
        int endIndex = 12;
        for (int i = startIndex; i < endIndex && i < maskedString.length(); i++) {
            if (Character.isDigit(maskedString.charAt(i))) {
                maskedString.setCharAt(i, '*');
            }
        }
        return maskedString.toString();
    }

}
