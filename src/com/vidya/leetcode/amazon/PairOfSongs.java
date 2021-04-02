package com.vidya.leetcode.amazon;

import java.util.HashMap;
import java.util.Map;

public class PairOfSongs {


    public static void main(String[] args) {

        int[] time = {100,20};
        System.out.println(numPairsDivisibleBy60(time));
    }

    static  int numPairsDivisibleBy60(int[] time) {

        Map<Integer, Integer> countMap = new HashMap<>();
        int count = 0;

        for(int t: time){
            int mod = t % 60;
            int compliment = mod == 0? 0: 60 - mod;

            count += countMap.getOrDefault(compliment, 0);

            countMap.put(mod, countMap.getOrDefault(mod, 0) + 1);
        }

        return count;
    }
}
