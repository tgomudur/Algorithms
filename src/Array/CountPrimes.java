package Array;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by tharun on 1/7/17.
 */

class CountPrimesSolution {
    public void markMultiples(int[] sieve, int num, int n) {
        int i = 2;
        while (i*num <= n) {
            sieve[i*num] = 1;
            i++;
        }
    }

    public int countPrimes(int n) {
        int count = 0;
        int[] sieve = new int[n + 1];
        for (int i = 2; i < n; i++) {
            if (sieve[i] == 0) markMultiples(sieve, i, n);
        }

        for (int i = 2; i < n; i++) {
            if (sieve[i] == 0) count++;
        }

        return count;
    }
}

public class CountPrimes {
    @Test
    public void testCountPrimes() {
        CountPrimesSolution s = new CountPrimesSolution();
        assertEquals(4,s.countPrimes(10));
        assertEquals(1229,s.countPrimes(10000));

    }
}
