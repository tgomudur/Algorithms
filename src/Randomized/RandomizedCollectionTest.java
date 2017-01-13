package Randomized;

/**
 * Created by tharun on 1/12/17.
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class RandomizedCollectionTest {
    @Test
    public void testInsert() {
        RandomizedCollection rc = new RandomizedCollection();
        assertTrue(rc.insert(1));
        assertTrue(rc.insert(2));
        assertTrue(!rc.insert(1));
    }

    @Test
    public void testRemove() {
        RandomizedCollection rc = new RandomizedCollection();
        assertTrue(rc.insert(1));
        assertTrue(!rc.insert(1));
        assertTrue(!rc.remove(2));
        assertTrue(rc.remove(1));
    }

    @Test
    public void testGetRandom() {
        RandomizedCollection rc = new RandomizedCollection();
        assertTrue(rc.insert(1));
        assertEquals(1, rc.getRandom());
    }
}
