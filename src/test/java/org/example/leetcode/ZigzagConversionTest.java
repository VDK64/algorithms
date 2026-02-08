package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ZigzagConversionTest {

    private ZigzagConversion underTest;

    @BeforeEach
    void setUp() {
        underTest = new ZigzagConversion();
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void shouldConvert(String input, int rows, String expected) {
        String result = underTest.convert(input, rows);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of("ABCD", 2, "ACBD"),
                Arguments.of("ABC", 2, "ACB"),
                Arguments.of("AB", 1, "AB"),
                Arguments.of("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"),
                Arguments.of("PAYPALISHIRING", 4, "PINALSIGYAHRPI"),
                Arguments.of("A", 1, "A")
        );
    }
}