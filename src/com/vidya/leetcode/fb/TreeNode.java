package com.vidya.leetcode.fb;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
    public TreeNode (TreeNode left, TreeNode right, int val){
        this.left = left;
        this.right = right;
        this.val = val;
    }
}
