package com.vidya.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 * <p>
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 * <p>
 * Input: nums = []
 * Output: []
 * Example 3:
 * <p>
 * Input: nums = [0]
 * Output: []
 */
public class Sum3 {

    public static void main(String[] args) {

        Sum3 sum3 = new Sum3();
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(sum3.threeSum(nums));
    }

    List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int size = nums.length;
        //Sorting the Input Arrays
        Arrays.sort(nums);

        for (int i = 0; i < size && nums[i] <= 0; i++) {

            if (i == 0 || nums[i] != nums[i - 1]) {

                int low = i + 1, high = size - 1;

                while (low < high) {
                    if (nums[low] + nums[high] < -nums[i]) {
                        low++;
                    } else if (nums[low] + nums[high] > -nums[i]) {
                        high--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        low++;
                        high--;
                        // Checking the Duplicates and Skip the current value.
                        while (low < high && nums[low] == nums[low - 1]) {
                            low++;
                        }
                    }
                }
            }
        }

        return result;
    }
}
