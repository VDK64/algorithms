package org.example.leetcode;

import java.util.LinkedHashSet;
import java.util.Set;

public class LongestSubstring {

  public int lengthOfLongestSubstring(String s) {
    char[] charArray = s.toCharArray();
    Set<Character> filter = new LinkedHashSet<>();
    int totalResult = 0;
    int currentResult = 0;

    for (char current : charArray) {
      int initialSize = filter.size();
      filter.add(current);
      int afterAddingSize = filter.size();

      if (initialSize == afterAddingSize) {
        totalResult = Math.max(totalResult, currentResult);
        filter = calculateRemain(filter, current);
        currentResult = filter.size();
        filter.add(current);
      }

      currentResult++;
    }

    return Math.max(totalResult, currentResult);
  }

  private Set<Character> calculateRemain(Set<Character> filter, Character letter) {
    Set<Character> result = new LinkedHashSet<>();
    boolean repeatedLetter = false;

    for (Character current : filter) {
      if (repeatedLetter) {
        result.add(current);
      }

      if (current == letter) {
        repeatedLetter = true;
      }
    }

    return result;
  }
}