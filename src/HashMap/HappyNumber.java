package HashMap;

import java.util.HashSet;
/**
 * Created by tharun on 12/30/16.
 * Problem description: https://leetcode.com/problems/happy-number/
 */

class HappyNumberSolution {
    public int calculateSquareSum(int n){
        int totalSum = 0, digit = 0;
        while (n > 0){
            digit = n % 10;
            totalSum += digit*digit;
            n = n/10;
        }
        return totalSum;
    }

    // O(n) Space Complexity
    public boolean isHappy2(int n) {
        HashSet<Integer> seen = new HashSet<Integer>();
        int squareSum = calculateSquareSum(n);
        while (seen.add(squareSum) && squareSum != 1) {
            squareSum = calculateSquareSum(squareSum);
        }
        return (squareSum == 1);
    }

    // O(1) Space
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = calculateSquareSum(slow);
            fast = calculateSquareSum(calculateSquareSum(fast));
        } while (slow != fast);
        return (slow == 1);
    }
}

public class HappyNumber {
    public static void main (String[] args){
        HappyNumberSolution s = new HappyNumberSolution();
        System.out.println(s.isHappy(7));
    }
}
