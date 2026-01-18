package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxCounter = 0;
        int counter = 0;
        int left = 0;
        int right = 0;
        char[] chars = s.toCharArray();

        while (right < s.length()) {
            char currentChar = chars[right];
            Integer charIndex = map.getOrDefault(currentChar, -1);
            while (left <= charIndex) {
                counter--;
                left++;
            }

            map.put(currentChar, right);
            counter = right - left + 1;
            if (maxCounter < counter) {
                maxCounter = counter;
            }
            right++;
        }

        return maxCounter;
    }
}