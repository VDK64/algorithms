package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GasStationTest {
    private GasStation underTest;

    @BeforeEach
    void setUp() {
        underTest = new GasStation();
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void shouldCalculate(int[] gas, int[] cost, int expected) {
        int result = underTest.canCompleteCircuit(gas, cost);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(new int[]{3, 1, 1}, new int[]{1, 2, 2}, 0),
                Arguments.of(new int[]{2, 3, 4}, new int[]{3, 4, 3}, -1),
                Arguments.of(new int[]{1, 1, 1}, new int[]{4, 4, 4}, -1),
                Arguments.of(new int[]{5, 1, 2, 3, 4}, new int[]{4, 4, 1, 5, 1}, 4),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}, 3)
        );
    }
}