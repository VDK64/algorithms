package org.example.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TwoSumTest {

  private TwoSum twoSum;

  @BeforeEach
  void setUp() {
    twoSum = new TwoSum();
  }

  @ParameterizedTest
  @MethodSource("parametersProvider")
  void shouldMultiply_when_KeepFindingWIthSorting(int[] input, int target, int[] output) {
    int[] result = twoSum.twoSum(input, target);

    assertThat(result).containsExactlyInAnyOrder(output);
  }

  static Stream<Arguments> parametersProvider() {
    return Stream.of(
        Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
        Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
        Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1})
    );
  }
}