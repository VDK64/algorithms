package org.example.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CountSortTest {

  @Test
  void should_CountSortViaArray() {
    int[] input = {1, 2, 3, 3, 2, 1, 0, 1, 2, 3, 4, 1, 2, 3, 2, 1};
    int[] sortedInput = Arrays.stream(input)
        .sorted()
        .toArray();

    int[] result = CountSort.countSortViaArray(input);

    assertThat(result).isEqualTo(sortedInput);
  }

  @ParameterizedTest
  @NullAndEmptySource
  void should_CountSortViaArray_when_ArrayEmptyOrNull(int[] input) {
    int[] result = CountSort.countSortViaArray(input);

    assertThat(result).isEmpty();
  }
}