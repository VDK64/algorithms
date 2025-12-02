package org.example.leetcode;

public class Anagram {

  public static boolean isAnagram(String firstWord, String secondWord) {
    if (firstWord == null || firstWord.isEmpty()) {
      return false;
    }

    if (secondWord == null || secondWord.isEmpty()) {
      return false;
    }

    String loweredFirstWord = firstWord.toLowerCase();
    String loweredSecondWord = secondWord.toLowerCase();

    int minCharNumber = 'a';
    int maxCharNumber = 'z';

    char[] firstWordCharArray = loweredFirstWord.toCharArray();
    char[] secondWordCharArray = loweredSecondWord.toCharArray();

    int[] ints = new int[maxCharNumber - minCharNumber + 1];

    for (char currentChar : firstWordCharArray) {
      ints[currentChar - minCharNumber] += 1;
    }

    for (char currentChar : secondWordCharArray) {
      ints[currentChar - minCharNumber] -= 1;
    }

    for (int currentValue : ints) {
      if (currentValue != 0) {
        return false;
      }
    }

    return true;
  }
}