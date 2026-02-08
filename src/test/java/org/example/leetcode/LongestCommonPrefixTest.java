package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestCommonPrefixTest {
    private LongestCommonPrefix underTest;

    @BeforeEach
    void setUp() {
        underTest = new LongestCommonPrefix();
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void shouldFindCommonPrefix(String[] strs, String expected) {
        String result = underTest.longestCommonPrefix(strs);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(new String[]{"flower", "flow", "flight"}, "fl"),
                Arguments.of(new String[]{"ab", "a"}, "a"),
                Arguments.of(new String[]{}, ""),
                Arguments.of(new String[]{"a"}, "a"),
                Arguments.of(new String[]{"dog", "racecar", "car"}, "")
        );
    }

}