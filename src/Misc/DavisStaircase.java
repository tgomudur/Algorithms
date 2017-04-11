package Misc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Recursion: Davis' Staircase.
 * <a href='https://www.hackerrank.com/challenges/ctci-recursive-staircase'>More info</a>
 */
public class DavisStaircase {
    public static int solveMemoized(int n, int[] memo) {
        if (n == 0)
            return 1;

        if (n < 0)
            return 0;

        if (memo[n] != -1)
            return memo[n];

        int count = 0;

        for (int stepSize = 1; stepSize <= 3; stepSize++) {
            count += solveMemoized(n - stepSize, memo);
            memo[n] = count;
        }
        return count;
    }

    // If choices are only 1 and 2 steps, the sequence is fibonacci.
    public static int solveEfficient(int n) {
        if (n == 0 || n == 1)
            return 1;

        int n1 = 1;
        int n2 = 1;
        int sum = 0;

        for (int i = 2; i <= n; i++) {
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            int[] memo = new int[n + 1];
            Arrays.fill(memo, -1);
            System.out.println(solveMemoized(n, memo));
        }
    }
}
