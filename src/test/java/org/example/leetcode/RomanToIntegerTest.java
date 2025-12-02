package org.example.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RomanToIntegerTest {

  private RomanToInteger romanToInteger;

  @BeforeEach
  void setUp() {
    romanToInteger = new RomanToInteger();
  }

  @ParameterizedTest
  @CsvSource({
      "III,             3",
      "MCMXCIV,         1994",
      "LVIII,           58"
  })
  void should(String input, int output) {
    assertThat(romanToInteger.romanToInt(input)).isEqualTo(output);
  }
}