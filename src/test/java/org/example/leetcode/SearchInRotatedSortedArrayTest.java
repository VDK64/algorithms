package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SearchInRotatedSortedArrayTest {
    private SearchInRotatedSortedArray underTest;

    @BeforeEach
    void setUp() {
        underTest = new SearchInRotatedSortedArray();
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void shouldSearch(int[] nums, int target, int expected) {
        int result = underTest.search(nums, target);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(new int[]{3, 1}, 1, 1),
                Arguments.of(new int[]{1, 3}, 0, -1),
                Arguments.of(new int[]{3, 1}, 0, -1),
                Arguments.of(new int[]{1, 2, 3}, 0, -1),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1),
                Arguments.of(new int[]{1}, 0, -1)
        );
    }

}