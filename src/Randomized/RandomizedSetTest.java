package Randomized;

/**
 * Created by tharun on 1/12/17.
 * Problem description : https://leetcode.com/problems/insert-delete-getrandom-o1/
 * No duplicates allowed.
 */

import static org.junit.Assert.*;
import org.junit.Test;

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
