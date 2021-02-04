package com.vidya.leetcode.fb;

/**
 * 65. Valid Number
 * <p>
 * A valid number can be split up into these components (in order):
 * <p>
 * A decimal number or an integer.
 * (Optional) An 'e' or 'E', followed by an integer.
 * A decimal number can be split up into these components (in order):
 * <p>
 * (Optional) A sign character (either '+' or '-').
 * One of the following formats:
 * At least one digit, followed by a dot '.'.
 * At least one digit, followed by a dot '.', followed by at least one digit.
 * A dot '.', followed by at least one digit.
 * An integer can be split up into these components (in order):
 * <p>
 * (Optional) A sign character (either '+' or '-').
 * At least one digit.
 * For example, all the following are valid numbers: ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"], while the following are not valid numbers: ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"].
 * <p>
 * Given a string s, return true if s is a valid number.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "0"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "e"
 * Output: false
 * Example 3:
 * <p>
 * Input: s = "."
 * Output: false
 * Example 4:
 * <p>
 * Input: s = ".1"
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 20
 * s consists of only English letters (both uppercase and lowercase), digits (0-9), plus '+', minus '-', or dot '.'.
 */
public class ValidNumber {

    public static void main(String[] args) {

        String[] validNumbers = {"2", "0089", "-0.1", "+3.14", "4.", "-.9",
                "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};

        for(String validnum: validNumbers){
            System.out.println(isNumber(validnum));
        }

        String[] inValidNumbers = {"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"};

        for(String inValid: inValidNumbers){
           // System.out.println(isNumber(inValid));
        }


    }

    static boolean isNumber(String s) {
        s = s.trim();

        boolean numSeen = false;
        boolean eSeen = false;
        boolean dotSeen = false;
        boolean numberAfterE = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            //Number Validation
            if (Character.isDigit(c)) {
                numSeen = true;
                numberAfterE = true;
            } else if (c == 'e' || c == 'E') {
                //eSeen before NumberSeen
                if (eSeen || !numSeen) return false;
                numberAfterE = false;
                eSeen = true;

            } else if (c == '.') {
                if (eSeen || dotSeen) return false;
                dotSeen = true;
            } else if (c == '-' || c == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            }else {
                return false;
            }
        }

        return numSeen && numberAfterE;
    }
}
