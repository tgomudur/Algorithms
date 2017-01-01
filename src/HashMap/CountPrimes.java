package HashMap;

/**
 * Created by tharun on 12/31/16.
 * Problem description : https://leetcode.com/problems/count-primes/
 */

class CountPrimesSolution {

    // O(n^2) time complexity. Naive solution.
    public boolean isPrime(int n) {
        if (n == 1) return false;

        for (int i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0) return false;
        }
        return true;
    }

    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }
}
public class CountPrimes {
    public static void main(String[] args){
        CountPrimesSolution s = new CountPrimesSolution();
        System.out.println(s.countPrimes(15000));
    }
}
