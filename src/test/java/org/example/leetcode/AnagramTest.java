package org.example.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AnagramTest {

  @ParameterizedTest
  @CsvSource({
      "Listen,          Silent,           true",
      "ApPle,           PiNaCkle,         false",
      "Earth,           Heart,            true",
      "Race,            Cares,            false",
      "Race,            Care,             true",
      "Act,             Cat,              true",
  })
  void should_detectAnagram(String firstWord, String secondWord, boolean isAnagram) {
    boolean result = Anagram.isAnagram(firstWord, secondWord);

    assertThat(result).isEqualTo(isAnagram);
  }


  @ParameterizedTest
  @CsvSource(value = {
      "null,            Silent,           false",
      "Silent,          null,             false",
      ",                Silent,           false",
      "Silent,          ,                 false",
  }, nullValues = "null")
  void should_DetectAnagramIfWordsNullOrEmpty(String firstWord, String secondWord,
      boolean isAnagram) {
    boolean result = Anagram.isAnagram(firstWord, secondWord);

    assertThat(result).isEqualTo(isAnagram);
  }
}