package com.vidya.leetcode;

/**
 * 91. Decode Ways
 * <p>
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * <p>
 * The answer is guaranteed to fit in a 32-bit integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 * <p>
 * Input: s = "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * Example 3:
 * <p>
 * Input: s = "0"
 * Output: 0
 * Explanation: There is no character that is mapped to a number starting with '0'. We cannot ignore a zero when we face it while decoding. So, each '0' should be part of "10" --> 'J' or "20" --> 'T'.
 * Example 4:
 * <p>
 * Input: s = "1"
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 100
 * s contains only digits and may contain leading zero(s).
 */
public class DecodeWays {

    public static void main(String[] args) {

        String str = "12";
        System.out.println(decodeWays(str));
    }

    static int decodeWays(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        int n = input.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = input.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= input.length(); i++) {
            int oneDigit = Integer.valueOf(input.substring(i - 1, i));
            int twoDigit = Integer.valueOf(input.substring(i - 2, i));

            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
