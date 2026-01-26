package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BestTimeToBuyAndSellStockTest {
    private BestTimeToBuyAndSellStock underTest;

    @BeforeEach
    void setUp() {
        underTest = new BestTimeToBuyAndSellStock();
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void shouldMaxProfit(int[] input, int expected) {
        int result = underTest.maxProfit(input);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void shouldMaxProfit_when_Enhanced(int[] input, int expected) {
        int result = underTest.enhancedMaxProfit(input);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 7),
                Arguments.of(new int[]{7, 6, 4, 3, 1}, 0)
        );
    }
}