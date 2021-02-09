package com.vidya.leetcode.fb;

import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * 269. Alien Dictionary
 * <p>
 * There is a new alien language that uses the English alphabet. However, the order among letters are unknown to you.
 * <p>
 * You are given a list of strings words from the dictionary, where words are sorted lexicographically by the rules of this new language.
 * <p>
 * Derive the order of letters in this language, and return it. If the given input is invalid, return "". If there are multiple valid solutions, return any of them.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["wrt","wrf","er","ett","rftt"]
 * Output: "wertf"
 * Example 2:
 * <p>
 * Input: words = ["z","x"]
 * Output: "zx"
 * Example 3:
 * <p>
 * Input: words = ["z","x","z"]
 * Output: ""
 * Explanation: The order is invalid, so return "".
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] consists of only lowercase English letters.
 */
public class AlienDictionary {

    public static void main(String[] args) {

        String[] str = {"wrt","wrf","er","ett","rftt"};

        System.out.println(alienOrder(str));

        String[] str1 = {"abc","ab"};
        System.out.println(alienOrder(str1));

    }

    static String alienOrder(String[] words) {
        int[] inDegree = new int[26];

        //Directed Graph
        Map<Character, Set<Character>> graph = new HashMap<>();
        //Build Graph
        buildGraph(graph, words, inDegree);
        return bfs(graph, inDegree);
    }

    static String bfs(Map<Character, Set<Character>> graph, int[] inDegree){

        StringBuilder sb = new StringBuilder();
        int totalChars = graph.size();

        Queue<Character> queue = new LinkedList<>();

        for(char c: graph.keySet()){
            if(inDegree[c - 'a']==0){
                sb.append(c);
                queue.offer(c);
            }
        }

        while (!queue.isEmpty()){
            char current = queue.poll();

            if(graph.get(current) == null || graph.get(current).size() == 0) continue;

            for(char neighbor: graph.get(current)){
                inDegree[neighbor - 'a']--;
                if(inDegree[neighbor -'a'] == 0){
                    queue.offer(neighbor);
                    sb.append(neighbor);
                }
            }
        }

        return sb.length() == totalChars? sb.toString():"";
    }

    static void buildGraph(Map<Character, Set<Character>> graph, String[] words, int[] inDegree) {

        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        for (int i = 1; i < words.length; i++) {
            String first = words[i - 1];
            String second = words[i];

            int len = Math.min(first.length(), second.length());

            for (int j = 0; j < len; j++) {
                if(first.charAt(j)!=second.charAt(j)){
                    char out = first.charAt(j);
                    char in = second.charAt(j);


                    if(!graph.get(out).contains(in)){
                        graph.get(out).add(in);
                        inDegree[in - 'a']++;
                    }

                    break;
                }
            }
        }
    }
}
