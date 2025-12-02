package org.example.leetcode;

import java.util.Arrays;

public class CountSortWithIndent {

  public static int[] count(int[] input) {
    if (input == null || input.length == 0) {
      return new int[0];
    }

    int maxValue = Arrays.stream(input)
        .max()
        .orElseThrow();

    int minValue = Arrays.stream(input)
        .min()
        .orElseThrow();

    int[] ints = new int[maxValue - minValue + 1];

    for (int value : input) {
      ints[value - minValue] += 1;
    }

    int[] sortedArray = new int[input.length];
    int currentValue = 0;

    for (int i = 0; i < ints.length; i++) {
      while (ints[i] > 0) {
        sortedArray[currentValue++] = i + minValue;
        ints[i]--;
      }
    }

    return sortedArray;
  }
}
