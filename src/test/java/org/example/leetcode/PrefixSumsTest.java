package org.example.leetcode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.util.TestUtil.LARGE_ARRAY_DATA_FILE;
import static org.example.util.TestUtil.SPLITTER;
import static org.example.util.TestUtil.processFile;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PrefixSumsTest {

  private PrefixSums underTest;

  @BeforeEach
  void setUp() {
    underTest = new PrefixSums();
  }

  @ParameterizedTest
  @MethodSource("argumentMethod")
  void shouldMaxSubarray(int[] nums, int k, long expected) {
    long result = underTest.maxSubarraySum(nums, k);

    assertThat(result).isEqualTo(expected);
  }

  @Test
  void shouldMaxSubarrayWithLongInput() {
    int[] nums = Arrays.stream(processFile(LARGE_ARRAY_DATA_FILE).get(0)
            .split(SPLITTER))
        .mapToInt(Integer::parseInt)
        .toArray();

    long result = underTest.maxSubarraySum(nums, 46);

    Assertions.assertThat(result).isEqualTo(33237830803L);
  }


  static List<Arguments> argumentMethod() {
    return List.of(
        Arguments.of(new int[]{-1, -2, -3, -4, -5}, 4, -10L),
        Arguments.of(new int[]{-5, 1, 2, -3, 4}, 2, 4L),
        Arguments.of(new int[]{-8}, 1, -8L),
        Arguments.of(new int[]{1, -4, 8, 12, -3, 5, 2, -1, 6}, 3, 26L),
        Arguments.of(new int[]{-10, -1}, 1, -1L),
        Arguments.of(new int[]{1, 2}, 1, 3L)
    );
  }

}