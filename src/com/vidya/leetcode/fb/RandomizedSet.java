package com.vidya.leetcode.fb;

import java.util.*;

public class RandomizedSet {


    Map<Integer,Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Random random = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {

    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(10));
        System.out.println(randomizedSet.insert(30));
        System.out.println(randomizedSet.insert(40));
        System.out.println(randomizedSet.insert(50));
        System.out.println(randomizedSet.insert(60));
        System.out.println(randomizedSet.insert(20));
        System.out.println(randomizedSet.remove(30));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(40));
        System.out.println(randomizedSet.insert(20));
        System.out.println(randomizedSet.getRandom());

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {

        if(map.containsKey(val)) return false;

        map.put(val,map.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {

        if(!map.containsKey(val)) return false;

        System.out.println(map.get(val));
        System.out.println(list.get(list.size()-1));

        list.set(map.get(val), list.get(list.size()-1));

        map.put(list.remove(list.size()-1), map.get(val));
        map.remove(val);

        System.out.println(map.toString());
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
