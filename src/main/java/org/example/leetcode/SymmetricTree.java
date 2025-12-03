package org.example.leetcode;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class SymmetricTree {

  public boolean isSymmetric(TreeNode root) {
    Deque<TreeNode> searchingQueue = new LinkedList<>();
    searchingQueue.add(root.left);
    searchingQueue.add(root.right);

    List<TreeNode> nested = new ArrayList<>();
    List<Integer> vertexes = new ArrayList<>();
    boolean checkSymmetry = false;

    while (!searchingQueue.isEmpty() || !nested.isEmpty()) {
      if (searchingQueue.isEmpty()) {
        searchingQueue.addAll(nested);
        nested.clear();
        checkSymmetry = true;
      }

      TreeNode element = searchingQueue.pollFirst();

      addNestedNodes(element, nested);

      if (checkSymmetry/* || nested.isEmpty()*/) {
        if (!isSymmetric(vertexes)) {
          return false;
        }

        vertexes.clear();
        checkSymmetry = false;
      }

      vertexes.add(element.val);

    }

    return isSymmetric(vertexes);
  }

  private void addNestedNodes(TreeNode element, List<TreeNode> nested) {
    TreeNode left = element.left;
    TreeNode right = element.right;
    if (left != null) {
      nested.add(left);
    }
    if (right != null) {
      nested.add(right);
    }
  }

  private boolean isSymmetric(List<Integer> vertexes) {
    if (vertexes.size() == 2) {
      return vertexes.get(0).equals(vertexes.get(1));
    } else {
      for (int i = 0; i < vertexes.size() / 2; i++) {
        Integer left = vertexes.get(i);
        Integer right = vertexes.get(vertexes.size() - 1 - i);
        if (!left.equals(right)) {
          return false;
        }
      }
    }

    return true;
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