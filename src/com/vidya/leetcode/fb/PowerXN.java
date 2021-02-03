package com.vidya.leetcode.fb;

public class PowerXN {

    public static void main(String[] args) {
        double x = 2.00000;
        int n = 6;

        System.out.println(myPow(x,n));

    }

    static double myPow(double x, int n) {

        long N = n;

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1;
        double currentProduct = x;

        for (long i = N; i > 0; i /= 2) {

            if (i % 2 == 1) {
                result *= currentProduct;
            }

            currentProduct *= currentProduct;

        }

        return result;
    }
}
