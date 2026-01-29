package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SortAnArrayTest {
    private SortAnArray underTest;

    @BeforeEach
    void setUp() {
        underTest = new SortAnArray();
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void shouldSort(int[] nums, int[] expected) {
        int[] result = underTest.sortArray(nums);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(new int[]{5, 1, 1, 2, 0, 0}, new int[]{0, 0, 1, 1, 2, 5}),
                Arguments.of(new int[]{5, 2, 3, 1}, new int[]{1, 2, 3, 5})
        );
    }
}