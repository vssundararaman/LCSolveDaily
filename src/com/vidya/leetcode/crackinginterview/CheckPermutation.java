package com.vidya.leetcode.crackinginterview;

public class CheckPermutation {

    public static void main(String[] args) {

        System.out.println(checkPermuatation("dog","god"));
    }

    static boolean checkPermuatation(String str1, String str2){

        int[] chars = new int[128];

        for(char c: str1.toCharArray()){
            chars[c-'a']++;
        }

        for(char c: str2.toCharArray()){
            chars[c-'a']--;
        }

        for(int i = 0; i< chars.length;i++){
            if(chars[i]>0){
                return false;
            }
        }

        return true;
    }
}
