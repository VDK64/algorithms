package org.example.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class AddTwoDigits {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int remainder = 0;
    boolean cont = true;
    Deque<ListNode> nodes = new LinkedList<>();

    while (cont) {
      Integer first = null;
      Integer second = null;
      if (l1 != null) {
        first = l1.val;
      }
      if (l2 != null) {
        second = l2.val;
      }

      if (first == null && second == null && remainder == 0) {
        cont = false;
        continue;
      }

      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }

      int result = 0;
      if (first != null && second != null) {
        result = first + second;
      } else if (first != null) {
        result = first;
      } else if (second != null) {
        result = second;
      }

      if (remainder > 0) {
        result += remainder;
        remainder = 0;
      }

      if (result > 9) {
        remainder = result / 10;
        result = result % 10;
      }

      ListNode resultNode = new ListNode();
      resultNode.val = result;
      ListNode last = nodes.peekLast();
      if (last != null) {
        last.next = resultNode;
      }
      nodes.add(resultNode);
    }

    return nodes.getFirst();
  }

  public static final class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof ListNode listNode)) {
        return false;
      }
      return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
      return Objects.hash(val, next);
    }
  }
}
