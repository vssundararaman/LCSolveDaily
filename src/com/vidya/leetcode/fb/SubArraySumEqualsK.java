package com.vidya.leetcode.fb;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. Subarray Sum Equals K
 *
 */
public class SubArraySumEqualsK {

    public static void main(String[] args) {

        int[] nums = {1,1,1};
        System.out.println(subarraySum(nums,2));
    }

    static int subarraySum(int[] nums, int k) {

        Map<Integer,Integer> sumMap = new HashMap<>();
        sumMap.put(0,1);
        int sum = 0;
        int result = 0;

        for(int i=0;i<nums.length;i++){
            sum += nums[i];

            if(sumMap.containsKey(sum-k)){
                result +=sumMap.get(sum-k);
            }

            sumMap.put(sum,sumMap.getOrDefault(sum,0)+1);
        }

        return result;
    }
}
