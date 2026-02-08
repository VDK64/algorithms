package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {

    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<List<Character>> zigZag = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            zigZag.add(new ArrayList<>());
        }

        int vertical = 0;
        boolean vert = true;

        for (int i = 0; i < s.length(); i++) {
            zigZag.get(vertical).add(s.charAt(i));
            if (vertical == numRows - 1) {
                vert = false;
            }
            if (vertical == 0) {
                vert = true;
            }
            if (vert) {
                vertical++;
            } else {
                vertical--;
            }
        }

        StringBuilder result = new StringBuilder();

        for (List<Character> characters : zigZag) {
            for (Character character : characters) {
                result.append(character);
            }
        }

        return result.toString();
    }
}
