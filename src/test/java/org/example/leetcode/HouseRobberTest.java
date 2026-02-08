package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class HouseRobberTest {
    private HouseRobber underTest;

    @BeforeEach
    void setUp() {
        underTest = new HouseRobber();
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void should(int[] input, int expected) {
        int result = underTest.rob(input);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(new int[]{2, 1, 1, 2}, 4),
                Arguments.of(new int[]{0}, 0),
                Arguments.of(new int[]{1, 2}, 2),
                Arguments.of(new int[]{1, 2, 3, 1}, 4),
                Arguments.of(new int[]{2, 7, 9, 3, 1}, 12)
        );
    }

}