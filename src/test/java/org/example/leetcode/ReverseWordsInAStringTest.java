package org.example.leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseWordsInAStringTest {

    private ReverseWordsInAString underTest;

    @BeforeEach
    void setUp() {
        underTest = new ReverseWordsInAString();
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void shouldReverse(String input, String expected) {
        String result = underTest.reverseWords(input);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of("the sky is blue", "blue is sky the"),
                Arguments.of("  hello world  ", "world hello"),
                Arguments.of("a good   example", "example good a")
        );
    }

}