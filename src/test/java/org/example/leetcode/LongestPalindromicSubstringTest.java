package org.example.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class LongestPalindromicSubstringTest {

  private LongestPalindromicSubstring underTest;

  @BeforeEach
  void setUp() {
    underTest = new LongestPalindromicSubstring();
  }

  @ParameterizedTest
  @MethodSource("methodSource")
  void shouldFindLongestPalindromicSubstring(String input, List<String> expected) {
    String result = underTest.longestPalindrome(input);

    assertThat(result).isIn(expected);
  }

  @ParameterizedTest
  @CsvSource({
      "zzzzzzzzzzz, zzzzzzzzzzz",
      "abcda,       a",
      "cbbd,        bb",
      "ccc,         ccc",
      "bb,          bb",
      "ac,          a",
      "a,           a",
  })
  void shouldFindLongestPalindrome2(String input, String expected) {
    String result = underTest.longestPalindrome(input);

    assertThat(result).isEqualTo(expected);
  }

  private static List<Arguments> methodSource() {
    return List.of(
        Arguments.of("ac", List.of("a")),
        Arguments.of("a", List.of("a")),
        Arguments.of("selevelar", List.of("level")),
        Arguments.of("babad", List.of("bab", "aba")),
        Arguments.of("moamadamzys", List.of("madam")),
        Arguments.of("cbbd", List.of("bb"))
    );
  }

}