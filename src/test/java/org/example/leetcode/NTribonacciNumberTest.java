package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class NTribonacciNumberTest {

    private NTribonacciNumber underTest;

    @BeforeEach
    void setUp() {
        underTest = new NTribonacciNumber();
    }

    @ParameterizedTest
    @CsvSource({
            "1,         1",
            "4,         4",
            "25,        1389537",
    })
    void shouldCalculate(int input, int expected) {
        int result = underTest.tribonacci(input);

        assertThat(result).isEqualTo(expected);
    }
}