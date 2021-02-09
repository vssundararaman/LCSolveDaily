package com.vidya.leetcode.fb;

import java.util.*;

/**
 * 249. Group Shifted Strings
 */
public class GroupStrings {

    public static void main(String[] args) {

        String[] str= {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        System.out.println(groupStrings(str));
    }

    static List<List<String>> groupStrings(String[] strings){

        Map<String, List<String>> map = new HashMap<>();

        for(String str: strings){
            String key = "";
            char first = str.charAt(0);
            for(char c: str.toCharArray())
                key +=(c-first<0?c-first+26:c-first);
                if(!map.containsKey(key))
                    map.put(key,new ArrayList<String>());
                map.get(key).add(str);
        }

        for(String key: map.keySet()){
            Collections.sort(map.get(key));
        }

        return new ArrayList<List<String>>(map.values());
    }
}
