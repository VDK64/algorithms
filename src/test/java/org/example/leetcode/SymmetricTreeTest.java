package org.example.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.example.leetcode.SymmetricTree.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Disabled
class SymmetricTreeTest {

  private SymmetricTree underTest;

  @BeforeEach
  void setUp() {
    underTest = new SymmetricTree();
  }

  @ParameterizedTest
  @MethodSource("argumentSources")
  void shouldReturnIsSymmetric(TreeNode root, boolean expected) {
    boolean result = underTest.isSymmetric(root);

    assertThat(result).isEqualTo(expected);
  }

  @Test
  void shouldReturnIsSymmetric() {
    boolean result = underTest.isSymmetric(new TreeNode(1));

    assertThat(result).isEqualTo(true);
  }

  static Stream<Arguments> argumentSources() {
    return Stream.of(
        Arguments.of(createSecondTreeNode(), false),
        Arguments.of(createFirstTreeNode(), true)
    );
  }

  private static TreeNode createSecondTreeNode() {
    TreeNode three = new TreeNode(3);
    TreeNode leftTwo = new TreeNode(2, null, three);
    TreeNode rightTwo = new TreeNode(2, null, three);

    return new TreeNode(1, leftTwo, rightTwo);
  }

  private static TreeNode createFirstTreeNode() {
    TreeNode three = new TreeNode(3);
    TreeNode four = new TreeNode(4);
    TreeNode leftTwo = new TreeNode(2, three, four);
    TreeNode rightTwo = new TreeNode(2, four, three);

    return new TreeNode(1, leftTwo, rightTwo);
  }
}