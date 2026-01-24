package org.example.leetcode;

import org.example.groking.QuickSort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class QuickSortTest {

    private QuickSort underTest;

    @BeforeEach
    void setUp() {
        underTest = new QuickSort();
    }

    @ParameterizedTest
    @MethodSource("provideArraysForTesting")
    void should_QuickSort_when_InputProvided(List<Integer> input) {
        List<Integer> algoSorted = underTest.sort(input);
        List<Integer> sorted = input.stream().sorted().toList();

        assertThat(algoSorted).isEqualTo(sorted);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void should_QuickSort_when_NoInput(List<Integer> input) {
        List<Integer> algoSorted = underTest.sort(input);

        assertThat(algoSorted).isEmpty();
    }

    private static Stream<Arguments> provideArraysForTesting() {
        return Stream.of(
                Arguments.of(List.of(1, 9, 4, 8, 2)),
                Arguments.of(
                        List.of(1, 2, 3, 4, 1, 3, 4, 5, 13, 451, 3453, 4523, 45, 61, 1, 342345345, 5,
                                31, 12435, 1, 345, 13, 45, 6, 7, 8, 5, 4, 3, 6, 7)
                ),
                Arguments.of(List.of(5)),
                Arguments.of(List.of(10, 5))
        );
    }
}