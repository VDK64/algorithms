package org.example.groking;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BinarySearchTest {

  private BinarySearch underTest;

  @BeforeEach
  void setUp() {
    underTest = new BinarySearch();
  }

  @ParameterizedTest
  @MethodSource("argumentSource")
  void shouldSearch() {
    int[] input = new int[]{1, 2, 3, 4, 5, 6};

    int result = underTest.search(input, 5);

    assertThat(result).isEqualTo(4);
  }

  private static List<Arguments> argumentSource() {
    return List.of(
        Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 5, 4),
        Arguments.of(new int[]{3, 1, 2, 6, 5, 4}, 5, 4),
        Arguments.of(new int[]{3, 1, 2, 6, 5, 4}, 2, 1)
    );
  }

}