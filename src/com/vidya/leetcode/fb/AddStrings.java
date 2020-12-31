package com.vidya.leetcode.fb;

public class AddStrings {

    public static void main(String[] args) {
        System.out.println(addStrings("1000","9878"));
    }

    static String addStrings(String num1, String num2) {

        StringBuilder result = new StringBuilder();

        int carry = 0;
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;

        while (p1 >= 0 || p2 >= 0) {
            int x = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int y = p2 >= 0 ? num2.charAt(p2) - '0' : 0;

            int sum = (x + y + carry) % 10;

            carry = (x + y + carry) / 10;

            result.append(sum);
            p1--;
            p2--;
        }

        if (carry != 0) {
            result.append(carry);
        }

        return result.reverse().toString();

    }
}
