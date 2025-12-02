package org.example.groking;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RecursionTest {

  private Recursion underTest;

  @BeforeEach
  void setUp() {
    underTest = new Recursion();
  }

  @Test
  void shouldUseRecursion() {
    long result = underTest.recursionFactorial(25L);

    assertThat(result).isEqualTo(7034535277573963776L);
  }


  @Test
  void shouldDivide() {
    int length = 1680;
    int width = 640;

    int[] result = underTest.divide(length, width);

    assertThat(result).containsExactly(80, 80);
  }

  @ParameterizedTest
  @MethodSource("arraySumMethodSource")
  void shouldSum(int[] input, long expected) {

    long result = underTest.sumRecursive(input);

    assertThat(result).isEqualTo(expected);
  }

  @ParameterizedTest
  @MethodSource("countArrayElementsMethodSource")
  void shouldCountArrayElements(int[] input, int expected) {
    int result = underTest.countArrayElements(input);

    assertThat(result).isEqualTo(expected);
  }


  @ParameterizedTest
  @MethodSource("maxInArrayMethodSource")
  void shouldFindMaxElementInArray(int[] input, int expected) {
    int result = underTest.maxArrayElement(input);

    assertThat(result).isEqualTo(expected);
  }


  private static List<Arguments> arraySumMethodSource() {
    return List.of(
        Arguments.of(new int[]{6, 4, 2}, 12L),
        Arguments.of(new int[]{1, 17, 8, -5, 3, 20, 7, -10, 2}, 43L)
    );
  }

  private static List<Arguments> countArrayElementsMethodSource() {
    return List.of(
        Arguments.of(new int[]{2, 4, 6}, 3),
        Arguments.of(new int[]{1, 17, 8, -5, 3, 2, 7, -10, 20}, 9)
    );
  }

  private static List<Arguments> maxInArrayMethodSource() {
    return List.of(
        Arguments.of(new int[]{6, 4, 2}, 6),
        Arguments.of(new int[]{3, 7, 2}, 7),
        Arguments.of(new int[]{3, 2, 7}, 7),
        Arguments.of(new int[]{1, 17, 8, -5, 20, 2, 7, -10, 3}, 20)
    );
  }
}