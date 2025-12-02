package org.example.groking;

import java.util.Arrays;

public class SelectionSort {

  public int[] sortAscending(int[] input) {
    int[] tempArray = Arrays.copyOf(input, input.length);
    int[] result = new int[input.length];
    int currentIndex = 0;
    int smallestIndex = 0;

    for (int i = 0; i < input.length; i++) {
      smallestIndex = findSmallestIndex(tempArray);
      result[currentIndex] = input[smallestIndex];
      currentIndex++;
    }

    return result;
  }

  public int[] sortDescending(int[] input) {
    int[] tempArray = Arrays.copyOf(input, input.length);
    int[] result = new int[input.length];
    int currentIndex = 0;
    int biggestIndex = 0;

    for (int i = 0; i < input.length; i++) {
      biggestIndex = findBiggestIndex(tempArray);
      result[currentIndex] = input[biggestIndex];
      currentIndex++;
    }

    return result;
  }

  private int findBiggestIndex(int[] input) {
    int biggestIndex = 0;
    int biggestValue = input[biggestIndex];

    for (int i = 0; i < input.length; i++) {
      if (biggestValue < input[i]) {
        biggestIndex = i;
        biggestValue = input[i];
      }
    }

    input[biggestIndex] = Integer.MIN_VALUE;

    return biggestIndex;
  }

  private int findSmallestIndex(int[] input) {
    int smallestIndex = 0;
    int smallestValue = input[smallestIndex];

    for (int i = 0; i < input.length; i++) {
      if (smallestValue > input[i]) {
        smallestIndex = i;
        smallestValue = input[i];
      }
    }

    input[smallestIndex] = Integer.MAX_VALUE;
    return smallestIndex;
  }
}