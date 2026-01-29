package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumSizeSubarraySumTest {
    private MinimumSizeSubarraySum underTest;

    @BeforeEach
    void setUp() {
        underTest = new MinimumSizeSubarraySum();
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void shouldFindMinimumSubarray(int[] nums, int target, int expected) {
        int result = underTest.minSubArrayLen(target, nums);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 1, 2, 4, 3}, 7, 2),
                Arguments.of(new int[]{1, 4, 4}, 4, 1),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1, 1}, 11, 0)
        );
    }
}