package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

}