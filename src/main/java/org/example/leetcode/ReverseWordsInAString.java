package org.example.leetcode;

public class ReverseWordsInAString {

    public String reverseWords(String s) {
        String input = s.trim().replaceAll("\\s+", " ");
        StringBuilder result = new StringBuilder();
        String[] stringArray = input.split(" ");
        for (int i = stringArray.length - 1; i >= 0; i--) {
            result.append(stringArray[i]);
            if (i != 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}
