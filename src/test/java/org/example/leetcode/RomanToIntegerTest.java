package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RomanToIntegerTest {

    private RomanToInteger romanToInteger;

    @BeforeEach
    void setUp() {
        romanToInteger = new RomanToInteger();
    }

    @ParameterizedTest
    @CsvSource({
            "MCMXCIV,         1994",
            "III,             3",
            "LVIII,           58"
    })
    void should(String input, int output) {
        assertThat(romanToInteger.romanToInt(input)).isEqualTo(output);
    }
}