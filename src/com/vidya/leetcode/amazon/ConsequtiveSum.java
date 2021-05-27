package com.vidya.leetcode.amazon;

public class ConsequtiveSum {

    public static void main(String[] args) {

        System.out.println(consecutiveNumbersSum(5));
    }

    static int consecutiveNumbersSum(int N) {
        int sum =0, ans = 0;

        for(int i=1;sum<N;i++){
            sum +=i;

            if(((N-sum) % i)==0){
                ans++;
            }

        }

        return ans;
    }
}
