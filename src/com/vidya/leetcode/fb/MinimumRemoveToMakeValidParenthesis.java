package com.vidya.leetcode.fb;

public class MinimumRemoveToMakeValidParenthesis {

    public static void main(String[] args) {

        String s = "))((";

        System.out.println(minRemoveToMakeValid(s));

    }


    static String minRemoveToMakeValid(String s) {

        StringBuilder sb = new StringBuilder();

        int open = 0;

        for(char ch:s.toCharArray()){

            if(ch == '('){
                open++;
            }else if(ch==')'){
                if(open == 0) continue;
                open--;
            }

            sb.append(ch);
        }

        StringBuilder result = new StringBuilder();

        for(int i=sb.length()-1;i>=0;i--){
            if(sb.charAt(i)=='(' && open-->0) continue;

            result.append(sb.charAt(i));
        }

        return result.reverse().toString();
    }
}
