package com.vidya.leetcode;

import java.util.*;
/**
 * 49. Group Anagrams
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lower-case English letters.
 *
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] str = {"eat","tea","tan","ate","nat","bat"};

        System.out.println(groupAnagrams.groupAnagrams(str));
    }

    List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> result = new ArrayList<>();

        Map<String, ArrayList<String>> map = new HashMap<>();

        for(String str: strs){
            char[] arr = new char[26];

            for(char ch: str.toCharArray()){
                arr[ch - 'a']++;
            }

            String newString = new String(arr);

            if(map.containsKey(newString)){
                map.get(newString).add(str);
            }else{
                ArrayList<String> al = new ArrayList<>();
                al.add(str);
                map.put(newString,al);
            }
        }

        result.addAll(map.values());

        return result;
    }
}
