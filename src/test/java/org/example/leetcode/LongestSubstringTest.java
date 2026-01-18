package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LongestSubstringTest {

    private LongestSubstring underTest;

    @BeforeEach
    void setup() {
        underTest = new LongestSubstring();
    }

    @ParameterizedTest
    @CsvSource({
            "aabaab!bb,         3",
            "pwwkew,            3",
            "abcabcbb,          3",
            "vdabcdef,          6",
            "dvdf,              3",
            "aab,               2",
            "bbbbb,             1"
    })
    void shouldGetSubstring(String input, int expected) {
        int result = underTest.lengthOfLongestSubstring(input);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void shouldGetSubstring_when_EmptyInput() {
        String empty = " ";
        int result = underTest.lengthOfLongestSubstring(empty);

        assertThat(result).isEqualTo(1);
    }
}