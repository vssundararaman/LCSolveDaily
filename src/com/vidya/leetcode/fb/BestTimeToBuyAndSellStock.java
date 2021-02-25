package com.vidya.leetcode.fb;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {

        int[] prices = {6,3,5,0,0,3,9,5};
        System.out.println(maxProfit2(prices));
    }

    static int maxProfit(int[] prices) {

        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;

        for (int i : prices) {
            release2 = Math.max(release2, hold2 + i);
            hold2 = Math.max(hold2, release1 - i);
            release1 = Math.max(release1, hold1 + i);
            hold1 = Math.max(hold1, -i);

        }

        return release2;
    }

    static int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int fb = Integer.MIN_VALUE, sb = Integer.MIN_VALUE, tb = Integer.MIN_VALUE;
        int fs = 0, ss = 0, ts = 0;

        for (int price : prices) {

            fb = Math.max(fb, -price);
            fs = Math.max(fs, fb + price);
            sb = Math.max(sb, fs - price);
            ss = Math.max(ss, sb + price);
            tb = Math.max(tb, ss - price);
            ts = Math.max(ts, tb + price);
        }

        return ts;
    }
}
