package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class HIndexTest {
    private HIndex underTest;

    @BeforeEach
    void setUp() {
        underTest = new HIndex();
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void shouldCalculateHIndex(int[] citations, int expected) {
        int result = underTest.hIndex(citations);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 1, 2, 3, 3, 3}, 3),
                Arguments.of(new int[]{3, 0, 6, 1, 5}, 3),
                Arguments.of(new int[]{100}, 1),
                Arguments.of(new int[]{0}, 0),
                Arguments.of(new int[]{1, 3, 1}, 1)
        );
    }
}