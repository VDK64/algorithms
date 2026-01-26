package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MajorityElementTest {

    private MajorityElement underTest;

    @BeforeEach
    void setUp() {
        underTest = new MajorityElement();
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void shouldFindMajorityElement(int[] input, int expected) {
        int result = underTest.majorityElement(input);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 3}, 3),
                Arguments.of(new int[]{2, 2, 1, 1, 1, 2, 2}, 2),
                Arguments.of(new int[]{1, 2, 3, 1, 2, 7, 1, 3, 9}, 1)
        );
    }

}