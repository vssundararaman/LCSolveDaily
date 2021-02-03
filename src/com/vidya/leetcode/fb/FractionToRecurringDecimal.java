package com.vidya.leetcode.fb;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {

    public static void main(String[] args) {
        int  numerator = 1, denominator = 4;

        System.out.println(fractionToDecimal(numerator,denominator));
    }

    static String fractionToDecimal(int numerator, int denominator) {

        if (numerator == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        if (numerator < 0 && denominator > 0 ||
                numerator > 0 && denominator < 0) {
            sb.append("-");
        }

        long divisor  = Math.abs((long) numerator);
        long dividend = Math.abs((long) denominator);

        long reminder = divisor % dividend;
        sb.append(divisor/dividend);

        if(reminder == 0){
            return sb.toString();
        }

        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();

        while(reminder !=0){

            if(map.containsKey(reminder)){
                sb.insert(map.get(reminder),"(");
                sb.append(")");
                break;
            }

            map.put(reminder,sb.length());
            reminder *=10;
            sb.append(reminder/dividend);
            reminder %= dividend;
        }

        return sb.toString();

    }
}

