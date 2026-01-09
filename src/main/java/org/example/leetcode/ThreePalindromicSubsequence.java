package org.example.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ThreePalindromicSubsequence {

    public int countPalindromicSubsequence(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        char[] chars = s.toCharArray();

        Set<Character> letters = new HashSet<>();
        int answerValue = 0;

        for (char currentChar : chars) {
            letters.add(currentChar);
        }

        for (Character currentLetter : letters) {
            int firstLetterIndex = -1;
            int lastLetterIndex = 0;

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == currentLetter) {
                    if (firstLetterIndex == -1) {
                        firstLetterIndex = i;
                    }
                    lastLetterIndex = i;
                }
            }

            Set<Character> answer = new HashSet<>();
            for (int i = firstLetterIndex + 1; i < lastLetterIndex; i++) {
                answer.add(chars[i]);
            }

            answerValue += answer.size();
        }

        return answerValue;
    }
}