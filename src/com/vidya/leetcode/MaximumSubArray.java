package com.vidya.leetcode;

public class MaximumSubArray {

    public static void main(String[] args) {

        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSubArray(nums));
    }

    static int maxSubArray(int[] nums) {

        int n = nums.length;
        int localMax = 0;
        int globalMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            localMax = Math.max(nums[i], nums[i] + localMax);
            if (localMax > globalMax) {
                globalMax = localMax;
            }
        }

        return globalMax;
    }
}
