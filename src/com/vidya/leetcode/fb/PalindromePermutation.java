package com.vidya.leetcode.fb;

import java.util.HashSet;
import java.util.Set;

/**
 * 266. Palindrome Permutation
 *
 * Given a string, determine if a permutation of the string could form a palindrome.
 *
 * Example 1:
 *
 * Input: "code"
 * Output: false
 * Example 2:
 *
 * Input: "aab"
 * Output: true
 * Example 3:
 *
 * Input: "carerac"
 * Output: true
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class PalindromePermutation {

    public static void main(String[] args) {

        System.out.println(isPalindrome("aab"));
    }

    static boolean isPalindrome(String string){
        Set<Character> hashSet = new HashSet<>();

        for(char c: string.toCharArray()){
            if(hashSet.contains(c)){
                hashSet.remove(c);
            }else{
                hashSet.add(c);
            }
        }

        return hashSet.size()<=1;
    }
}
