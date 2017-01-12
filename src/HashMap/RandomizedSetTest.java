package HashMap;

/**
 * Created by tharun on 1/12/17.
 * Problem description : https://leetcode.com/problems/insert-delete-getrandom-o1/
 * No duplicates allowed.
 */

import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

class RandomizedSet {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> keyList;
    Random rand;


    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        keyList = new ArrayList<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, keyList.size());
            keyList.add(val);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        // Deleting tail in DLL is O(1).
        // Copy last element value to current val's position and deleting last position.
        if (map.containsKey(val)) {
            // Copy and update
            int currentValIdx = map.get(val);
            keyList.set(currentValIdx, keyList.get(keyList.size() - 1));
            map.put(keyList.get(keyList.size() - 1), currentValIdx);
            // Remove
            keyList.remove(keyList.size() - 1);
            map.remove(val);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return keyList.get(rand.nextInt(keyList.size()));
    }
}

public class RandomizedSetTest {
    @Test
    public void testInsert() {
        RandomizedSet rs = new RandomizedSet();
        assertTrue(rs.insert(2));
        assertTrue(rs.insert(1));
        assertTrue(!rs.insert(2));
    }

    @Test
    public void testRemove() {
        RandomizedSet rs = new RandomizedSet();
        assertTrue(!rs.remove(100));
        assertTrue(rs.insert(100));
        assertTrue(rs.remove(100));
    }

    @Test
    public void testGetRandom() {
        RandomizedSet rs = new RandomizedSet();
        assertTrue(rs.insert(100));
        assertEquals(100, rs.getRandom());
    }
}
