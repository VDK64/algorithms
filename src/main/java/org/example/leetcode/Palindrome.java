package org.example.leetcode;

public class Palindrome {

    public boolean isPalindromeString(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }

        String cleaned = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] wordChars = cleaned.toCharArray();
        boolean isPalindrome = true;

        for (int i = 0; i < word.length() - 1; i++) {
            if (i == cleaned.length() / 2) {
                break;
            }

            char frontLetter = wordChars[i];
            char backLetter = wordChars[(cleaned.length() - 1) - i];
            if (frontLetter != backLetter) {
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }

    public boolean isPalindrome(int x) {
        char[] charArray = String.valueOf(x).toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (i == charArray.length / 2) {
                break;
            }

            char leftSide = charArray[i];
            char rightSide = charArray[charArray.length - 1 - i];

            if (leftSide != rightSide) {
                return false;
            }
        }

        return true;
    }
}