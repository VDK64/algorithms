package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveDuplicatesFromSortedArrayTest {

    private RemoveDuplicatesFromSortedArray underTest;

    @BeforeEach
    void setUp() {
        underTest = new RemoveDuplicatesFromSortedArray();
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void removeDuplicates(int[] nums, int[] expectedNums) {
        int result = underTest.removeDuplicates(nums);

        assertThat(result).isEqualTo(expectedNums.length);
        for (int i = 0; i < result; i++) {
            assert nums[i] == expectedNums[i];
        }
    }

    private static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(new int[]{1}, new int[]{1}),
                Arguments.of(new int[]{1, 1}, new int[]{1, 1}),
                Arguments.of(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 3, 3}),
                Arguments.of(new int[]{1, 1, 1, 2, 2, 3}, new int[]{1, 1, 2, 2, 3})
        );
    }

}