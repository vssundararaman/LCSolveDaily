package com.vidya.leetcode.fb;

/**
 * Time complexity: O(kn) where k is k, n is the number of prices
 * Space complexity: O(kn)
 */
public class BestTimeToBuyAndSellStockIV {

    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        int k = 2;

        System.out.println(maxProfit(k,prices));
    }

    static int maxProfit(int k, int[] prices) {

        int n = prices.length;

        if (k >= n / 2) {
            //Fast Case because there are [0, n/2] continuous process
            int maxProfit = 0;

            for (int i = 1; i < n; i++) {
                int diff = prices[i] - prices[i - 1];

                if (diff > 0) {
                    maxProfit += diff;
                }
            }

            return maxProfit;
        }

        // Each element dp[i][j] means the max profit of at most i transactions until day j
        int[][] dp = new int[k + 1][n];
        int localMax = Integer.MIN_VALUE;

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < n; j++) {
                localMax = Math.max(localMax, dp[i - 1][j - 1] - prices[j - 1]);

                //Sell Price Adding here
                dp[i][j] = Math.max(dp[i][j - 1], localMax + prices[j]);
            }

            localMax = Integer.MIN_VALUE;
        }
        return dp[k][n - 1];
    }
}
