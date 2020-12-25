package com.vidya.leetcode.fb;

import java.util.HashMap;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};

        System.out.println(canPartition(nums));

        int[] nums1 = {3, 3, 3, 4, 5};
        System.out.println(canPartition(nums1));
    }

    static boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int total = 0;

        for (int num : nums) {
            total += num;
        }

        if (total % 2 != 0) {
            return false;
        }


        return canPartition(nums, 0, 0, total, new HashMap<String, Boolean>());
    }

    private static boolean canPartition(int[] nums, int index, int sum, int total,
                                        HashMap<String, Boolean> state) {

        String current = index + "" + sum;

        if (state.containsKey(current)) {
            return state.get(current);
        }


        if (sum * 2 == total) {
            return true;
        }

        if (sum > total / 2 || index >= nums.length) {
            return false;
        }

        Boolean foundPartition = canPartition(nums, index + 1, sum, total, state) ||
                canPartition(nums, index + 1, sum + nums[index], total, state);

        state.put(current, foundPartition);
        return foundPartition;
    }
}
