package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindIndexFirstOccurrenceInStringTest {
    private FindIndexFirstOccurrenceInString underTest;

    @BeforeEach
    void setUp() {
        underTest = new FindIndexFirstOccurrenceInString();
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void shouldFindOccurence(String haystack, String needle, int expectedIndex) {
        int result = underTest.strStr(haystack, needle);

        assertThat(result).isEqualTo(expectedIndex);
    }

    private static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of("mississippi", "issip", 4),
                Arguments.of("aaa", "aaaa", -1),
                Arguments.of("leetcode", "leeto", -1),
                Arguments.of("mississippi", "issi", 1),
                Arguments.of("a", "a", 0),
                Arguments.of("sadbutsad", "sad", 0)
        );
    }
}