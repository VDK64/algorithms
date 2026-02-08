package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class IntegerToRomanTest {

    private IntegerToRoman underTest;

    @BeforeEach
    void setUp() {
        underTest = new IntegerToRoman();
    }

    @ParameterizedTest
    @CsvSource({
            "3749,          MMMDCCXLIX",
            "58,            LVIII",
            "1994,          MCMXCIV",
    })
    void shouldConvertToRoman(int num, String expected) {
        String result = underTest.intToRoman(num);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 15,100,150,155,1500,1555,3999})
    void should(int input) {
        underTest.intToRoman(input);
    }
}