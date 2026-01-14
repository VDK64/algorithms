package org.example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeLevelOrderTraversalTest {
    private BinaryTreeLevelOrderTraversal underTest;

    @BeforeEach
    void setUp() {
        underTest = new BinaryTreeLevelOrderTraversal();
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void shouldTraverseLevelOrder(BinaryTreeLevelOrderTraversal.TreeNode root, List<List<Integer>> expected) {
        List<List<Integer>> lists = underTest.levelOrder(root);

        assertThat(lists).isEqualTo(expected);
    }

    @Test
    void shouldTraverseLevelOrder_when_InputIsNull() {
        List<List<Integer>> lists = underTest.levelOrder(null);

        assertThat(lists).isEqualTo(List.of());
    }

    private static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(initialize(asList(3, 9, 20, null, null, 15, 7)), asList(of(3), asList(9, 20), asList(15, 7)))
        );
    }

    private static BinaryTreeLevelOrderTraversal.TreeNode initialize(List<Integer> nodes) {
        Queue<BinaryTreeLevelOrderTraversal.TreeNode> queue = new LinkedList<>();
        BinaryTreeLevelOrderTraversal.TreeNode root = new BinaryTreeLevelOrderTraversal.TreeNode(nodes.get(0));
        queue.add(root);
        int counter = 1;

        while (counter < nodes.size()) {
            BinaryTreeLevelOrderTraversal.TreeNode current = queue.poll();
            if (current != null) {
                if (counter < nodes.size() && nodes.get(counter) != null) {
                    current.left = new BinaryTreeLevelOrderTraversal.TreeNode(nodes.get(counter));
                    queue.add(current.left);
                }

                counter++;

                if (counter < nodes.size() && nodes.get(counter) != null) {
                    current.right = new BinaryTreeLevelOrderTraversal.TreeNode(nodes.get(counter));
                    queue.add(current.right);
                }

                counter++;
            }
        }

        return root;
    }
}