package com.vidya.leetcode.fb;

/**
 *  81. Search in Rotated Sorted Array II
 *
 * There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
 *
 * Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
 *
 * Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * nums is guaranteed to be rotated at some pivot.
 * -104 <= target <= 104
 *
 *
 * Follow up: This problem is the same as Search in Rotated Sorted Array, where nums may contain duplicates. Would this affect the runtime complexity? How and why?
 *
 * Time Complexity O(N) and best case O(N Log N)
 */
public class SearchInRotatedSortedArrayII {


    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        System.out.println(search(nums,0));

        int[] nums1 = {2,5,6,0,0,1,2};
        System.out.println(search(nums1,3));
    }

    static boolean search(int[] nums, int target){
        int start = 0, end = nums.length-1,mid = -1;

        while(start < end){

            mid = start + (end-start) / 2;

            if(nums[mid] == target){
                return true;
            }
            //If we know for sure right side is sorted or left side is unsorted
            if(nums[mid] < nums[end] || nums[mid] < nums[start]){
                if(target > nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
            //If we know for sure left side is sorted or right side is unsorted
            else if (nums[mid] > nums[start] || nums[mid] > nums[end]){
                if(target < nums[mid] && target >= nums[start]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                end --;
            }
        }
        return false;
    }
}
