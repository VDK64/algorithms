package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

class RemoveArrayElementTest {
    private RemoveArrayElement underTest;

    @BeforeEach
    void setUp() {
        underTest = new RemoveArrayElement();
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void shouldRemoveElement(int[] nums, int val, int expected, int[] expectedNums) {
        int result = underTest.removeElement(nums, val);

        int[] array = Arrays.stream(nums)
                .filter(n -> n != val)
                .sorted()
                .toArray();
        assertThat(result).isEqualTo(expected);
        assertThat(array).isEqualTo(expectedNums);
    }

    private static Stream<Arguments> methodSource() {
        return Stream.of(
                of(new int[]{3, 2, 2, 3}, 3, 2, new int[]{2, 2}),
                of(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, 5, new int[]{0, 0, 1, 3, 4})
        );
    }
}