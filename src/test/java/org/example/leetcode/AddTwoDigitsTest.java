package org.example.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.example.leetcode.AddTwoDigits.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AddTwoDigitsTest {

  private AddTwoDigits underTest;

  @BeforeEach
  void setUp() {
    underTest = new AddTwoDigits();
  }

  @ParameterizedTest
  @MethodSource("twoDigitsMethodSource")
  void shouldAddTwoDigits(ListNode left, ListNode right, ListNode expected) {
    ListNode listNode = underTest.addTwoNumbers(left, right);

    assertThat(listNode).isEqualTo(expected);
  }

  private static List<Arguments> twoDigitsMethodSource() {
    return List.of(
        Arguments.of(
            new ListNode(2, new ListNode(4, new ListNode(3))),
            new ListNode(5, new ListNode(6, new ListNode(4))),
            new ListNode(7, new ListNode(0, new ListNode(8)))
        ),
        Arguments.of(
            new ListNode(0),
            new ListNode(0),
            new ListNode(0)
        ),
        Arguments.of(
            new ListNode(9,
                new ListNode(9,
                    new ListNode(9,
                        new ListNode(9,
                            new ListNode(9,
                                new ListNode(9,
                                    new ListNode(9))))))),
            new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))),
            new ListNode(8,
                new ListNode(9,
                    new ListNode(9,
                        new ListNode(9,
                            new ListNode(0,
                                new ListNode(0,
                                    new ListNode(0,
                                        new ListNode(1)))))))))
    );
  }

}