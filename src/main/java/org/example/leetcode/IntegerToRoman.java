package org.example.leetcode;

public class IntegerToRoman {

    public String intToRoman(int num) {
        if (num == 0) return "";

        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];

            while (num >= value) {
                result.append(symbol);
                num -= value;
            }
        }

        return result.toString();
    }
}
