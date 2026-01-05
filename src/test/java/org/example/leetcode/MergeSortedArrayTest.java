package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

class MergeSortedArrayTest {
    private MergeSortedArray mergeSortedArray;

    @BeforeEach
    void setUp() {
        mergeSortedArray = new MergeSortedArray();
    }

    @ParameterizedTest
    @MethodSource("argumentsSource")
    void shouldMergeArrays(int[] nums1, int m, int[] nums2, int n, int[] expected) {
        mergeSortedArray.merge(nums1, m, nums2, n);

        assertThat(nums1).containsExactly(expected);
    }

    private static Stream<Arguments> argumentsSource() {
        return Stream.of(
                of(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3, new int[]{1, 2, 2, 3, 5, 6}),
                of(new int[]{1}, 1, new int[]{}, 0, new int[]{1}),
                of(new int[]{0}, 0, new int[]{1}, 1, new int[]{1}),
                of(new int[]{2, 0}, 1, new int[]{1}, 1, new int[]{1, 2}),
                of(new int[]{0, 0}, 0, new int[]{-50, -48}, 2, new int[]{-50, -48})
        );
    }
}