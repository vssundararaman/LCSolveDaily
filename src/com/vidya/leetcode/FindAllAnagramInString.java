package com.vidya.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
 * <p>
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * <p>
 * Input:
 * s: "abab" p: "ab"
 * <p>
 * Output:
 * [0, 1, 2]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagramInString {

    public static void main(String[] args) {

        FindAllAnagramInString findAllAnagramInString = new FindAllAnagramInString();
        String s = "cbaebabacd", p = "abc";

        System.out.println(findAllAnagramInString.findAllAnagrams(s, p));

        s= "abab"; p= "ab";

        System.out.println(findAllAnagramInString.findAllAnagrams(s, p));
    }

    List<Integer> findAllAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (s == null || s.length() == 0 || s.length() < p.length()) {
            return result;
        }
        int[] charMap = new int[26];
        int count = 0;

        for (char ch : p.toCharArray()) {
            count++;
            charMap[ch - 'a']++;
        }

        int left = 0;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            charMap[c - 'a']--;
            count--;

            if (count == 0) {

                if (allZeros(charMap)) {
                    result.add(left);
                }

                char lc = s.charAt(left);
                charMap[lc - 'a']++;

                left++;
                count++;
            }
        }

        return result;
    }

    boolean allZeros(int[] charMap) {
        for (int i : charMap) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
