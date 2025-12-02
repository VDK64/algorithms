package org.example.leetcode.symmetricTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;
import org.example.leetcode.symmetricTree.SymmetricTree.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Disabled
class SymmetricTreeTest {

  private SymmetricTree symmetricTree;

  @BeforeEach
  void setUp() {
    symmetricTree = new SymmetricTree();
  }

  @ParameterizedTest
  @MethodSource("argumentSources")
  void should_IsSymmetric(List<Integer> inputList, boolean isSymmetric) {
//    boolean result = symmetricTree.isSymmetric(inputList);
    for (int i = inputList.size(); i >= 0; i--) {
      System.out.println();
    }

//    assertThat(result).isEqualTo(isSymmetric);
  }

  static Stream<Arguments> argumentSources() {
    return Stream.of(
        Arguments.of(createTreeNode(List.of(1, 2, 2, 3, 4, 4, 3)), true),
        Arguments.of(List.of(1, 2, 2, null, 3, null, 3), false)
    );
  }

  private static TreeNode createTreeNode(List<Integer> integers) {
    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode root = new TreeNode(integers.get(0));
    queue.offer(root);
    int i = 1;
    while (!queue.isEmpty() && i < integers.size()) {

    }

    return null;
  }
}