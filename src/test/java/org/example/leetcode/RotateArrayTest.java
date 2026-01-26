package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RotateArrayTest {
    private RotateArray underTest;

    @BeforeEach
    void setUp() {
        underTest = new RotateArray();
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void shouldRotate(int[] input, int k, int[] expected) {
        underTest.rotate(input, k);

        assertThat(input).isEqualTo(expected);
    }

    private static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(new int[]{-1}, 2, new int[]{-1}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 3, new int[]{5, 6, 7, 1, 2, 3, 4}),
                Arguments.of(new int[]{-1, -100, 3, 99}, 2, new int[]{3, 99, -1, -100})
        );
    }

}