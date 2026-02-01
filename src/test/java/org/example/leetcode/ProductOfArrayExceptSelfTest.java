package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ProductOfArrayExceptSelfTest {
    private ProductOfArrayExceptSelf underTest;

    @BeforeEach
    void setUp() {
        underTest = new ProductOfArrayExceptSelf();
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void shouldCalculateHIndex(int[] input, int[] expected) {
        int[] result = underTest.productExceptSelf(input);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 4, 5}, new int[]{60, 40, 30, 24}),
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{24, 12, 8, 6}),
                Arguments.of(new int[]{-1, 1, 0, -3, 3}, new int[]{0, 0, 9, 0, 0})
        );
    }
}