package com.vidya.leetcode;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 * Example 4:
 *
 * Input: s = "([)]"
 * Output: false
 * Example 5:
 *
 * Input: s = "{[]}"
 * Output: true
 *
 */
public class ValidParenthesis {

    public static void main(String[] args) {
        ValidParenthesis validParenthesis = new ValidParenthesis();
        String s = "()";
        System.out.println(validParenthesis.isValidParenthesis(s));

        s = "()[]{}";
        System.out.println(validParenthesis.isValidParenthesis(s));

        s = "(]";
        System.out.println(validParenthesis.isValidParenthesis(s));

        s = "([)]";
        System.out.println(validParenthesis.isValidParenthesis(s));

        s = "{[]}";
        System.out.println(validParenthesis.isValidParenthesis(s));
    }

    boolean isValidParenthesis(String string) {

        if (string == null || string.length() == 0) {
            return false;
        }

        Stack<Character> characterStack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            Character currentChar = string.charAt(i);
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                characterStack.push(currentChar);
            } else if (!characterStack.isEmpty() &&
                    ((currentChar == '}' && characterStack.peek() == '{') ||
                            (currentChar == ']' && characterStack.peek() == '[') ||
                            (currentChar == ')' && characterStack.peek() == '('))) {
                characterStack.pop();
            } else {
                characterStack.push(currentChar);
            }
        }

        if(characterStack.isEmpty()){
            return true;
        }

        return false;
    }
}
