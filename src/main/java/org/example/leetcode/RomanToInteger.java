package org.example.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

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

    private static final Map<Character, Set<Character>> SUBTRACT = new LinkedHashMap<>() {{
        put('I', Set.of('V', 'X'));
        put('X', Set.of('L', 'C'));
        put('C', Set.of('D', 'M'));
    }};

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int result = 0;

        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];
            char nextChar = Character.MIN_VALUE;
            if (i + 1 < chars.length) {
                nextChar = chars[i + 1];
            }
            Set<Character> subtractions = SUBTRACT.get(current);
            Integer currentCost = LITERALS.get(current);

            if (subtractions != null && subtractions.contains(nextChar)) {
                Integer nextCost = LITERALS.get(nextChar);
                int temp = nextCost - currentCost;
                result += temp;

                if (i + 1 < chars.length) {
                    i++;
                }
            } else {
                result += currentCost;
            }
        }

        return result;
    }
}