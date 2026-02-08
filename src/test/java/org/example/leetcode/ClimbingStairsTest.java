package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ClimbingStairsTest {
    private ClimbingStairs underTest;

    @BeforeEach
    void setUp() {
        underTest = new ClimbingStairs();
    }

    @ParameterizedTest
    @CsvSource({
            "2,         2",
            "3,         3",
    })
    void shouldCalculate(int n, int expected) {
        int result = underTest.climbStairs(n);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void shouldCalculate2(int n, int[] input, int expected) {
        int result = underTest.climbStairs(n, input);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(1, new int[]{1}, 2),
                Arguments.of(0, new int[]{}, 0),
                Arguments.of(4, new int[]{1, 2, 3, 4}, 13),
                Arguments.of(4, new int[]{5, 1, 6, 2}, 11),
                Arguments.of(3, new int[]{9, 8, 3}, 12)
        );
    }

}