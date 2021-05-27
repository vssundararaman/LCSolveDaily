package com.vidya.leetcode.amazon;

import com.vidya.leetcode.fb.TreeNode;

/**
 * 1120. Maximum Average Subtree
 * iven the root of a binary tree, find the maximum average value of any subtree of that tree.
 *
 * (A subtree of a tree is any node of that tree plus all its descendants. The average value of a tree is the sum of its values, divided by the number of nodes.)
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: [5,6,1]
 * Output: 6.00000
 * Explanation:
 * For the node with value = 5 we have an average of (5 + 6 + 1) / 3 = 4.
 * For the node with value = 6 we have an average of 6 / 1 = 6.
 * For the node with value = 1 we have an average of 1 / 1 = 1.
 * So the answer is 6 which is the maximum.
 *
 *
 * Note:
 *
 * The number of nodes in the tree is between 1 and 5000.
 * Each node will have a value between 0 and 100000.
 * Answers will be accepted as correct if they are within 10^-5 of the correct answer.
 *
 */
public class MaximumAverageSubtree {

    private static double average = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(6);
        root.right = new TreeNode(1);

        helper(root);
        System.out.println(average);
    }


    private static int helper(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);
        int number = left + right + 1;

        if(left !=0){
            root.val += root.left.val;
        }

        if(right !=0){
            root.val += root.right.val;
        }

        average = Math.max(average,(double) (root.val)/number);

        return number;
    }

}
