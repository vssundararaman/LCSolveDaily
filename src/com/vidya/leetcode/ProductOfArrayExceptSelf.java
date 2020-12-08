package com.vidya.leetcode;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        ProductOfArrayExceptSelf self = new ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(self.productOfArray(nums)));
    }

    int[] productOfArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int n = nums.length;
        int[] output = new int[n];

        output[0] = 1;

        for (int i = 1; i < n; i++) {
            output[i] = nums[i - 1] * output[i - 1];
        }

        int R = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] = output[i] * R;
            R *= nums[i];
        }
        return output;
    }
}
