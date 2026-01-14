package org.example.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return List.of();
        }

        Queue<TreeNode> main = new LinkedList<>();
        Queue<TreeNode> level = new LinkedList<>();
        List<Integer> currentList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        main.add(root);

        while (!main.isEmpty()) {

            TreeNode node = main.poll();
            currentList.add(node.val);

            if (node.left != null) {
                level.add(node.left);
            }
            if (node.right != null) {
                level.add(node.right);
            }

            if (main.isEmpty()) {
                main.addAll(level);
                level.clear();
                result.add(currentList);
                currentList = new ArrayList<>();
            }
        }

        return result;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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
    }
}