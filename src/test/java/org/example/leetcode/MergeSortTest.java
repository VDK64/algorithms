package org.example.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class MergeSortTest {

  @Test
  void should_MergeSort_when_EvenSizeOfList() {
    List<Integer> input = List.of(2, 8, 5, 3, 9, 4, 1, 7);
    List<Integer> embeddedSortedList = new ArrayList<>(input);
    embeddedSortedList.sort(Comparator.naturalOrder());

    List<Integer> sort = MergeSort.sort(input);

    assertThat(sort).isEqualTo(embeddedSortedList);
  }

  @Test
  void should_MergeSort_when_OddSizeOfList() {
    List<Integer> input = List.of(2, 8, 5, 3, 9);
    List<Integer> embeddedSortedList = new ArrayList<>(input);
    embeddedSortedList.sort(Comparator.naturalOrder());

    List<Integer> sort = MergeSort.sort(input);

    assertThat(sort).isEqualTo(embeddedSortedList);
  }

  @ParameterizedTest
  @NullAndEmptySource
  void should_MergeSort_when_EmptyOrNullList(List<Integer> input) {
    List<Integer> sort = MergeSort.sort(input);

    assertThat(sort).isEmpty();
  }
}