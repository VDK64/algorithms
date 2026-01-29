package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class JumpGameTest {
    private JumpGame underTest;

    @BeforeEach
    void setUp() {
        underTest = new JumpGame();
    }

    @ParameterizedTest
    @MethodSource("methodSourceCanJump")
    void shouldCalculateJumpOpportunity(int[] input, boolean expected) {
        boolean result = underTest.canJump(input);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("methodSourceJump")
    void shouldCalculateJump(int[] input, int expected) {
        int result = underTest.jump(input);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> methodSourceCanJump() {
        return Stream.of(
                Arguments.of(new int[]{2, 2, 0, 1, 4}, true),
                Arguments.of(new int[]{0, 2, 3}, false),
                Arguments.of(new int[]{2, 0, 0}, true),
                Arguments.of(new int[]{2, 3, 1, 1, 4}, true),
                Arguments.of(new int[]{0}, true),
                Arguments.of(new int[]{3, 2, 1, 0, 4}, false)
        );
    }

    private static Stream<Arguments> methodSourceJump() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 0, 1, 4}, 2),
                Arguments.of(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0}, 2),
                Arguments.of(new int[]{2, 3, 1, 1, 4}, 2),
                Arguments.of(new int[]{1, 2, 1, 1, 1}, 3),
                Arguments.of(new int[]{2, 1}, 1)
        );
    }
}