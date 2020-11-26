package com.vidya.leetcode;

/**
 * 5. Longest Palindromic Substring
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 * Example 3:
 *
 * Input: s = "a"
 * Output: "a"
 * Example 4:
 *
 * Input: s = "ac"
 * Output: "a"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters (lower-case and/or upper-case),
 */
public class LongestPalindromeString {

    public static void main(String[] args) {
        String input = "this is malayalam";
        System.out.println(findLongestPalindromicString(input));
    }

    static String findLongestPalindromicString(String input){
        String output = "";
        if(input == null || input.length() == 0 ){
            return output;
        }

        for(int i = 0;i<input.length();i++){

            String odd = findPalindrome(input,i,i);
            if(odd.length()>output.length()){
                output = odd;
            }

            String even = findPalindrome(input,i,i+1);
            if(even.length() > output.length()){
                output = even;
            }
        }

        return output;
    }

    static String findPalindrome(String input, int left, int right){

        while (left>=0 && right < input.length() && input.charAt(left)==input.charAt(right)){
            left --;
            right ++;
        }

        return input.substring(left+1,right);
    }
}
