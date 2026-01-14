package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FirstAndLastPositionInSortedArrayTest {
    private FirstAndLastPositionInSortedArray underTest;

    @BeforeEach
    void setUp() {
        underTest = new FirstAndLastPositionInSortedArray();
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void shouldFindFirstAndLastPosition(int[] nums, int target, int[] expected) {
        int[] result = underTest.searchRange(nums, target);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(new int[]{1,1,1,2,4,4,4,5,5,5,5,6,7,8,8,9,9,9,9,9,9,10}, 9, new int[]{15, 20}),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 2, 3, 4, 4, 5, 5, 5, 6, 7, 8, 8, 8, 8}, 8, new int[]{15, 18}),
                Arguments.of(new int[]{5, 8, 8, 9, 10, 11, 12, 12}, 8, new int[]{1, 2}),
                Arguments.of(new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4}),
                Arguments.of(new int[]{5, 7, 7, 8, 8, 10}, 6, new int[]{-1, -1}),
                Arguments.of(new int[]{}, 0, new int[]{-1, -1})
        );
    }

}