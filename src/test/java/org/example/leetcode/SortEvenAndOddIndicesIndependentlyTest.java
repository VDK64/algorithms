package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SortEvenAndOddIndicesIndependentlyTest {

    private SortEvenAndOddIndicesIndependently underTest;

    @BeforeEach
    void setUp() {
        underTest = new SortEvenAndOddIndicesIndependently();
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void shouldSort(int[] input, int[] expected) {
        int[] result = underTest.sortEvenOdd(input);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(new int[]{4, 1, 2, 3}, new int[]{2, 3, 4, 1}),
                Arguments.of(new int[]{2, 1}, new int[]{2, 1})
        );
    }

}