package Randomized;

/**
 * Created by tharun on 1/12/17.
 * Problem description: https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 */

import java.util.*;

public class RandomizedCollection {
    HashMap<Integer, Set<Integer>> map;
    ArrayList<Integer> keyList;
    Random rand;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<Integer, Set<Integer>>();
        keyList = new ArrayList<Integer>();
        rand = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contains = map.containsKey(val);
        if (!contains) map.put(val, new HashSet<Integer>());
        map.get(val).add(keyList.size());
        keyList.add(val);
        return !contains;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int currentValIdx = map.get(val).iterator().next();
        int lastVal = keyList.get(keyList.size() - 1);
        // Copy last value to current value's idx
        keyList.set(currentValIdx, lastVal);
        map.get(val).remove(currentValIdx);
        map.get(lastVal).add(currentValIdx);
        keyList.remove(keyList.size() - 1);

        if (map.get(val).isEmpty()) map.remove(val);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return keyList.get(rand.nextInt(keyList.size()));
    }
}

