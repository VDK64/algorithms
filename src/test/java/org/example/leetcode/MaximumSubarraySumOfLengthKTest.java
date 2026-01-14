package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumSubarraySumOfLengthKTest {
    private MaximumSubarraySumOfLengthK underTest;

    @BeforeEach
    void setUp() {
        underTest = new MaximumSubarraySumOfLengthK();
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void shouldReturnMaximumSum(int[] nums, int k, int expected) {
        long result = underTest.maximumSubarraySum(nums, k);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 2, 5, 6, 7, 8}, 3, 21),
                Arguments.of(new int[]{1, 2, 1, 1, 3}, 2, 4),
                Arguments.of(new int[]{3, 1, 2, 2, 3}, 3, 6),
                Arguments.of(new int[]{5, 3, 3, 1, 1}, 3, 0),
                Arguments.of(new int[]{1, 5, 4, 2, 9, 9, 9}, 3, 15),
                Arguments.of(new int[]{3, 3, 3, 1, 2}, 4, 0),
                Arguments.of(new int[]{3, 2, 3, 1, 4, 5, 6, 7, 8, 9}, 3, 24),
                Arguments.of(new int[]{3, 2, 3, 1}, 3, 6),
                Arguments.of(new int[]{9, 9, 9, 1, 2, 3}, 3, 12),
                Arguments.of(new int[]{1, 1, 1, 7, 8, 9}, 3, 24),
                Arguments.of(new int[]{4, 4, 4}, 3, 0)
        );
    }
}