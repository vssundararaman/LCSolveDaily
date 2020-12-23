package com.vidya.leetcode.fb;

/**
 * 680. Valid Palindrome II
 *
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class ValidPalindromeII {

    public static void main(String[] args) {
        String str = "abca";
        System.out.println(validPalindrome(str));
    }

   static boolean validPalindrome(String s) {

        int i = 0;
        int j = s.length()-1;

        while(i<j){

            if(s.charAt(i)!=s.charAt(j)){
                return isValidPalindrome(s, i+1,j) || isValidPalindrome(s,i,j-1);
            }
            i++;
            j--;
        }
        return true;
   }

   static boolean isValidPalindrome(String s, int i, int j){

        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
   }
}
