package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MiddleOfTheLinkedListTest {
    private MiddleOfTheLinkedList underTest;

    @BeforeEach
    void setUp() {
        underTest = new MiddleOfTheLinkedList();
    }

    @Test
    void twoSum_when_OddCount() {
        MiddleOfTheLinkedList.ListNode node5 = new MiddleOfTheLinkedList.ListNode(5);
        MiddleOfTheLinkedList.ListNode node4 = new MiddleOfTheLinkedList.ListNode(4, node5);
        MiddleOfTheLinkedList.ListNode node3 = new MiddleOfTheLinkedList.ListNode(3, node4);
        MiddleOfTheLinkedList.ListNode node2 = new MiddleOfTheLinkedList.ListNode(2, node3);
        MiddleOfTheLinkedList.ListNode node1 = new MiddleOfTheLinkedList.ListNode(1, node2);

        MiddleOfTheLinkedList.ListNode result = underTest.middleNode(node1);

        assertThat(result.val).isEqualTo(3);
    }

    @Test
    void twoSum_when_EvenCount() {
        MiddleOfTheLinkedList.ListNode node6 = new MiddleOfTheLinkedList.ListNode(6);
        MiddleOfTheLinkedList.ListNode node5 = new MiddleOfTheLinkedList.ListNode(5, node6);
        MiddleOfTheLinkedList.ListNode node4 = new MiddleOfTheLinkedList.ListNode(4, node5);
        MiddleOfTheLinkedList.ListNode node3 = new MiddleOfTheLinkedList.ListNode(3, node4);
        MiddleOfTheLinkedList.ListNode node2 = new MiddleOfTheLinkedList.ListNode(2, node3);
        MiddleOfTheLinkedList.ListNode node1 = new MiddleOfTheLinkedList.ListNode(1, node2);

        MiddleOfTheLinkedList.ListNode result = underTest.middleNode(node1);

        assertThat(result.val).isEqualTo(4);
    }
}