package org.example.leetcode;

import java.util.Arrays;

public class CountSort {

  public static int[] countSortViaArray(int[] input) {
    if (input == null || input.length == 0) {
      return new int[0];
    }

    int maxValue = Arrays.stream(input)
        .max()
        .orElseThrow();

    int[] ints = new int[maxValue + 1];

    for (int value : input) {
      ints[value] = ints[value] + 1;
    }

    int[] sortedArray = new int[input.length];

    int index = 0;

    for (int i = 0; i < ints.length; i++) {
      while (ints[i] > 0) {
        sortedArray[index++] = i;
        ints[i]--;
      }
    }

    return sortedArray;
  }
}