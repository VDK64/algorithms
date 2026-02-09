package org.example.leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class UniquePathsTest {

    private UniquePaths underTest;

    @BeforeEach
    void setUp() {
        underTest = new UniquePaths();
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void shouldFindUniquePaths(int m, int n, int expected) {
        int result = underTest.uniquePaths(m, n);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("anotherMethodSource")
    void shouldFindUniquePathsWithObstacles(int[][] obstacleGrid, int expected) {
        int result = underTest.uniquePathsWithObstacles(obstacleGrid);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(2, 2, 2),
                Arguments.of(3, 7, 28),
                Arguments.of(3, 2, 3)
        );
    }

    private static Stream<Arguments> anotherMethodSource() {
        return Stream.of(
                Arguments.of(new int[][]{{0, 1, 0, 0}}, 0),
                Arguments.of(new int[][]{{1, 0}}, 0),
                Arguments.of(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}, 2),
                Arguments.of(new int[][]{{0, 1}, {0, 0}}, 1));
    }
}