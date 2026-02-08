package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LengthOfLastWordTest {
    private LengthOfLastWord underTest;

    @BeforeEach
    void setUp() {
        underTest = new LengthOfLastWord();
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void shouldFindMaximumSizedWord(String input, int expected) {
        int result = underTest.lengthOfLastWord(input);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of("Today is a nice day", 3),
                Arguments.of("luffy is still joyboy", 6),
                Arguments.of("Hello World", 5),
                Arguments.of("   fly me   to   the moon  ", 4)
        );
    }

}