package org.example.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CountSortWithIndentTest {

  @Test
  void should_Sort() {
    int[] input = {25, 20, 25, 25, 21, 23, 22, 25, 22, 21, 24};
    int[] sortedInput = Arrays.stream(input)
        .sorted()
        .toArray();

    int[] result = CountSortWithIndent.count(input);

    assertThat(result).isEqualTo(sortedInput);
  }


  @ParameterizedTest
  @NullAndEmptySource
  void should_Sort_when_EmptyOrNullInput(int[] input) {
    int[] result = CountSortWithIndent.count(input);

    assertThat(result).isEmpty();
  }
}