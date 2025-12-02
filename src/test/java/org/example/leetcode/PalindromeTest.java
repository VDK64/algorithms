package org.example.leetcode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class PalindromeTest {

  private Palindrome palindrome;

  @BeforeEach
  void setUp() {
    palindrome = new Palindrome();
  }

  @ParameterizedTest
  @CsvSource({
      "1221,              true",
      "121,               true",
      "-121,              false",
      "10,                false",
  })
  void shouldReturnIsPalindromeDigits(int input, boolean isPalindrome) {
    assertThat(palindrome.isPalindrome(input)).isEqualTo(isPalindrome);
  }

  @ParameterizedTest
  @ValueSource(strings = {
      "radar", "level", "madam", "racecar", "a", "deified",
      "A man a plan a canal Panama", "Was it a car or a cat I saw"
  })
  void shouldReturnTrueForPalindromes(String input) {
    assertTrue(palindrome.isPalindromeString(input));
  }

  @ParameterizedTest
  @ValueSource(strings = {
      "hello", "world", "java", "programming", "test", "not a palindrome"
  })
  void shouldReturnFalseForNonPalindromes(String input) {
    assertFalse(palindrome.isPalindromeString(input));
  }

  @ParameterizedTest
  @CsvSource({
      "radar, true",
      "level, true",
      "hello, false",
      "world, false",
      "a, true",
      "ab, false"
  })
  void shouldReturnExpectedResult(String input, boolean expected) {
    assertEquals(expected, palindrome.isPalindromeString(input));
  }

  @ParameterizedTest
  @NullAndEmptySource
  void shouldHandleNullAndEmpty(String input) {
    // Здесь зависит от требований - можно возвращать true или false
    // В данном примере предполагаем, что пустая строка и null не считаются палиндромами
    assertFalse(palindrome.isPalindromeString(input));
  }

  @Test
  void shouldHandleCaseSensitivity() {
    // Проверяем чувствительность к регистру
    assertTrue(palindrome.isPalindromeString("Radar")); // или false, зависит от реализации
  }
}