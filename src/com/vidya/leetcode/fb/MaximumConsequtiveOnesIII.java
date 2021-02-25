package com.vidya.leetcode.fb;

public class MaximumConsequtiveOnesIII {

    public static void main(String[] args) {

        int[] A = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println( maximumConsequtiveOnes(A, 2));
    }

    static int maximumConsequtiveOnes(int[] A, int k){
        int i = 0;
        int j = 0;

        while(i < A.length){
            if(A[i] == 0) {
                k--;
            }

            if(k < 0){
                if(A[j] == 0){
                    k++;
                }
                j++;
            }
            i++;
        }
        return i - j;
    }
}

