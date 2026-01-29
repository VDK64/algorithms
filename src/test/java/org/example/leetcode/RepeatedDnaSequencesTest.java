package org.example.leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class RepeatedDnaSequencesTest {
    private RepeatedDnaSequences underTest;

    @BeforeEach
    void setUp() {
        underTest = new RepeatedDnaSequences();
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void shouldFindRepeatedDnaSequences(String input, List<String> expected) {
        List<String> result = underTest.findRepeatedDnaSequences(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of("AAAAAAAAAAAAA", List.of("AAAAAAAAAA")),
                Arguments.of("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", List.of("AAAAACCCCC", "CCCCCAAAAA"))
        );
    }
}