package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinCostClimbingStairsTest {
    private MinCostClimbingStairs underTest;

    @BeforeEach
    void setUp() {
        underTest = new MinCostClimbingStairs();
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void climbStairs(int[] cost, int expected) {
        int result = underTest.minCostClimbingStairs(cost);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void climbStairs2(int[] cost, int expected) {
        int result = underTest.minCostClimbingStairs2(cost);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void climbStairs3(int[] cost, int expected) {
        int result = underTest.minCostClimbingStairs3(cost);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}, 6),
                Arguments.of(new int[]{10, 15, 20}, 15)
        );
    }

}