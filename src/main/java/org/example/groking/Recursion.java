package org.example.groking;

import static java.lang.System.arraycopy;
import static java.util.Arrays.copyOf;

public class Recursion {

  public long recursionFactorial(long x) {
    if (x <= 1) {
      return 1L;
    }

    return x * recursionFactorial(x - 1L);
  }

  public int[] divide(int length, int width) {
    int min = Math.min(length, width);
    int max = Math.max(length, width);
    int delta = max % min;

    if (delta == 0) {
      return new int[]{min, min};
    }

    return divide(min, delta);
  }

  public long sumRecursive(int[] input) {
    if (input.length == 1) {
      return input[0];
    }

    int[] tempArray = copyOf(input, input.length - 1);
    arraycopy(input, 1, tempArray, 0, input.length - 1);

    return input[0] + sumRecursive(tempArray);
  }

  public int countArrayElements(int[] input) {
    if (input.length == 1) {
      return 1;
    }

    int[] tempArray = copyOf(input, input.length - 1);
    arraycopy(input, 1, tempArray, 0, input.length - 1);

    return 1 + countArrayElements(tempArray);
  }

  public int maxArrayElement(int[] input, int... max) {
    max = max.length == 0 ? new int[]{Integer.MIN_VALUE} : new int[]{max[0]};
    int currentMax = Math.max(input[0], max[0]);
    if (input.length == 1) {
      return currentMax;
    }

    int[] tempArray = copyOf(input, input.length - 1);
    arraycopy(input, 1, tempArray, 0, input.length - 1);

    return maxArrayElement(tempArray, currentMax);
  }
}