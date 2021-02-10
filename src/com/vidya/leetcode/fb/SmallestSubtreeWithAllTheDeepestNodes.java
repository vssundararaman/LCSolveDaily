package com.vidya.leetcode.fb;

public class SmallestSubtreeWithAllTheDeepestNodes {

    static int maxDepth = -1;
    static TreeNode result = null;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        System.out.println(subTreeWithAllTheDeepestNodes(root).val);
    }

    static TreeNode subTreeWithAllTheDeepestNodes(TreeNode root) {

        if (root == null) {
            return null;
        }
        postOrder(root,0);
        return result;

    }

    static int postOrder(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }

        int left = postOrder(node.left, depth + 1);
        int right = postOrder(node.right, depth + 1);

        if (left == right) {
            maxDepth = Math.max(maxDepth, left);
            if (maxDepth == left) {
                result = node;
            }
        }
        return Math.max(left, right);
    }
}
