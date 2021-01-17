package com.vidya.leetcode.fb;

public class MinimumWindowSubstring {

    public static void main(String[] args) {

        String s = "ADOBECODEBANC", t = "ABC";

        System.out.println(minWindow(s,t));
    }


    static String minWindow(String s, String t) {

        if(s == null || s.length() ==0 || t == null || t.length() ==0){
            return "";
        }

        int[] letterCount = new int[128];
        int left = 0, count = 0, minLen = Integer.MAX_VALUE;
        String result = "";

        for(char c: t.toCharArray()){
            ++letterCount[c];
        }

        for(int right = 0; right < s.length(); right++){

            if(--letterCount[s.charAt(right)] >=0){
                ++count;

                while(count == t.length()){

                    if(minLen > right - left + 1){

                        minLen = right - left + 1;
                        result = s.substring(left, right + 1);

                    }
                    if(++letterCount[s.charAt(left)] > 0){
                        --count;
                    }
                    ++left;
                }
            }
        }

        return result;
    }
}
