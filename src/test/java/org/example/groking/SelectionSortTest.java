package org.example.groking;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SelectionSortTest {

  private SelectionSort underTest;

  @BeforeEach
  void setUp() {
    underTest = new SelectionSort();
  }

  @Test
  void shouldSortAscending() {
    int[] input = {5, 3, 6, 2, 10};

    int[] result = underTest.sortAscending(input);

    assertThat(result).containsExactly(2, 3, 5, 6, 10);
  }

  @Test
  void shouldSortDescending() {
    int[] input = {5, 3, 6, 2, 10};

    int[] result = underTest.sortDescending(input);

    assertThat(result).containsExactly(10, 6, 5, 3, 2);
  }
}