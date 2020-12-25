package com.vidya.leetcode.fb;

import java.util.Stack;

/**
 * 394. Decode String
 * Given an encoded string, return its decoded string.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * <p>
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 * <p>
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 * <p>
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * Example 4:
 * <p>
 * Input: s = "abc3[cd]xyz"
 * Output: "abccdcdcdxyz"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 */
public class DecodeString {

    public static void main(String[] args) {

        String s = "3[a]2[bc]";

        System.out.println(decodeString(s));
    }

    static String decodeString(String str) {
        String result = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int i = 0;

        while (i < str.length()) {

            if (Character.isDigit(str.charAt(i))) {
                int count = 0;
                while (Character.isDigit(str.charAt(i))) {
                    count = count * 10 + (str.charAt(i) - '0');
                    i++;
                }
                countStack.push(count);

            } else if (str.charAt(i) == '[') {

                stringStack.push(result);
                result = "";
                i++;
            } else if (str.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder(stringStack.pop());

                int count = countStack.pop();

                for (int j = 0; j < count; j++) {
                    sb.append(result);
                }
                result = sb.toString();
                i++;
            } else {
                result += str.charAt(i++);
            }
        }

        return result;
    }
}
