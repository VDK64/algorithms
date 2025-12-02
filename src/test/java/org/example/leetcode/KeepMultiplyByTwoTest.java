package org.example.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class KeepMultiplyByTwoTest {

  @ParameterizedTest
  @MethodSource("parametersProvider")
  void shouldMultiply_when_KeepFinding(int[] input, int original, int output) {
    int result = KeepMultiplyByTwo.findFinalValue(input, original);

    assertThat(result).isEqualTo(output);
  }

  @ParameterizedTest
  @MethodSource("parametersProvider")
  void shouldMultiply_when_KeepFindingWIthSorting(int[] input, int original, int output) {
    int result = KeepMultiplyByTwo.findFinalValueWithSorting(input, original);

    assertThat(result).isEqualTo(output);
  }

  static Stream<Arguments> parametersProvider() {
    return Stream.of(
        Arguments.of(new int[]{4, 2}, 2, 8),
        Arguments.of(new int[]{8, 19, 4, 2, 15, 3}, 2, 16),
        Arguments.of(new int[]{5, 3, 6, 1, 12}, 3, 24),
        Arguments.of(new int[]{2, 7, 9}, 4, 4)
    );
  }
}