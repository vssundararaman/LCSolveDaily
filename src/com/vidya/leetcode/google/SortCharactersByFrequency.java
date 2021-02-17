package com.vidya.leetcode.google;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * 451. Sort Characters By Frequency
 *
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 *
 * Input:
 * "cccaaa"
 *
 * Output:
 * "cccaaa"
 *
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 *
 * Input:
 * "Aabb"
 *
 * Output:
 * "bbAa"
 *
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 *
 * Time Complexity O(nLogN)
 */
public class SortCharactersByFrequency {

    public static void main(String[] args) {


    }

    static String frequencySort(String string){

        Map<Character, Integer> map = new HashMap<>();

        IntStream.range(0,string.length()).
                forEach(i ->map.put(string.charAt(i),map.getOrDefault(string.charAt(i),0)+1));

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap  = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());

        maxHeap.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()){
            Map.Entry e = maxHeap.poll();

            IntStream.range(0,(int)e.getValue()).forEach(i ->sb.append(e.getKey()));
        }

        return sb.toString();
    }
}
