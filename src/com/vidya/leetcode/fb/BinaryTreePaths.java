package com.vidya.leetcode.fb;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);

        System.out.println(binaryTreePaths(root));
    }

    static List<String> binaryTreePaths(TreeNode root){
        List<String> result = new ArrayList<>();
        if (root != null) searchBinaryTree(root, "", result);
        return result;
    }

    static void searchBinaryTree(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) answer.add(path + root.val);
        if (root.left != null) searchBinaryTree(root.left, path + root.val + "->", answer);
        if (root.right != null) searchBinaryTree(root.right, path + root.val + "->", answer);
    }
}
