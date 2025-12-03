package org.example.leetcode;

import java.util.Objects;

public class SymmetricTree {


  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return false;
    }

    return isSymmetric(root.left, root.right);
  }

  private boolean isSymmetric(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }

    if (left == null || right == null) {
      return false;
    }

    return (left.val == right.val)
        && isSymmetric(left.left, right.right)
        && isSymmetric(left.right, right.left);
  }

  public static final class TreeNode {

    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
      this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof TreeNode treeNode)) {
        return false;
      }
      return val == treeNode.val && Objects.equals(left, treeNode.left)
          && Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
      return Objects.hash(val, left, right);
    }
  }
}