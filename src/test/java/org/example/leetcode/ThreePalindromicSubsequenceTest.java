package org.example.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ThreePalindromicSubsequenceTest {

  private ThreePalindromicSubsequence underTest;

  @BeforeEach
  void setUp() {
    underTest = new ThreePalindromicSubsequence();
  }

  @ParameterizedTest
  @CsvSource({
      "ckafnafqo,     4",
      "abca,          2",
      "aabca,         3",
      "adc,           0",
      "bbcbaba,       4"
  })
  void should(String input, int result) {
    int output = underTest.countPalindromicSubsequence(input);
    assertThat(output).isEqualTo(result);
  }
}