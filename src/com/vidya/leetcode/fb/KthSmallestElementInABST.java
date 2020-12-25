package com.vidya.leetcode.fb;

/**
 * 230. Kth Smallest Element in a BST
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 *
 * Constraints:
 *
 * The number of elements of the BST is between 1 to 10^4.
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */
public class KthSmallestElementInABST {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(30);
        root.left = new TreeNode(10);
        root.left.right = new TreeNode(20);
        root.right = new TreeNode(40);

        System.out.println(kthSmallestElement(root,1));
    }

    static int kthSmallestElement(TreeNode root, int k){

        int[] nums = new int[2];
        inOrder(root,nums,k);
        return nums[1];
    }

    static void inOrder(TreeNode root, int[] nums, int k){
        if(root == null){
            return;
        }

        inOrder(root.left,nums, k);
        if(++nums[0] == k){
            nums[1] = root.val;
            return;
        }
        inOrder(root.right,nums,k);
    }
}
