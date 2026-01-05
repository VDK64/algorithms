package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

class RemoveDuplicatesFromArrayTest {
    private RemoveDuplicatesFromArray undertest;

    @BeforeEach
    void setUp() {
        undertest = new RemoveDuplicatesFromArray();
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void removeDuplicatesFromArray(int[] nums, int expected, int[] expectedNums) {
        int result = undertest.removeDuplicates(nums);

        Arrays.sort(nums);
        assertThat(result).isEqualTo(expected);
        assertThat(nums).isEqualTo(expectedNums);
    }

    private static Stream<Arguments> methodSource() {
        return Stream.of(
                of(new int[]{1, 2, 2, 2, 3, 4, 4}, 4, new int[]{1, 2, 3, 3, 4, 4, 4}),
                of(new int[]{1}, 1, new int[]{1}),
                of(new int[]{1, 1, 2}, 2, new int[]{1, 2, 2}),
                of(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, 5, new int[]{0, 1, 2, 2, 2, 3, 3, 3, 4, 4})
        );
    }

}