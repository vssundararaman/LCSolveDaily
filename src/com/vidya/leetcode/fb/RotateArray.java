package com.vidya.leetcode.fb;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7};
        rotateArray(nums,3);
    }
    static void rotateArray(int[] nums, int k) {
        //k = k % nums.length;

       // System.out.println(k);

        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

        System.out.println(Arrays.toString(nums));
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }

        System.out.println(Arrays.toString(nums));
    }
}
