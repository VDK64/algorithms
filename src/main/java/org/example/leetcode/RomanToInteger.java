package org.example.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanToInteger {

    private static final Map<Character, Integer> LITERALS = new LinkedHashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        boolean isSkipNext = false;

        for (int i = 0; i < chars.length; i++) {
            if (isSkipNext) {
                isSkipNext = false;
                continue;
            }

            char currentChar = chars[i];
            Integer currentValue = LITERALS.get(chars[i]);
            if (i == chars.length - 1) {
                result += LITERALS.get(currentChar);
            } else {
                char nextChar = chars[i + 1];
                Integer nextValue = LITERALS.get(chars[i + 1]);

                if (currentValue >= nextValue) {
                    result += currentValue;
                } else if (currentChar == 'I' || currentChar == 'X' || currentChar == 'C') {
                    result += nextValue - currentValue;
                    isSkipNext = true;
                }
            }
        }

        return result;
    }
}