package DP;

/**
 * <p>Coin Change</p>
 * <a href=https://www.hackerrank.com/challenges/ctci-coin-change>More Info</a>
 */

public class CoinChange {
    // Recursive solution.
    // Time complexity:  O(2^n). Space complexity: O(n) [call stack size = n levels]
    public long makeChangeHelper(int[] coins, int coinsLeft, int moneyLeft) {
        // Reached goal
        if (moneyLeft == 0)
            return 1;

        // Impossible to give perfect change with current path
        if (moneyLeft < 0)
            return 0;

        // Moneyleft but no denominations
        if (moneyLeft > 0 && coinsLeft <= 0)
            return 0;

        // Count the number of sets of solution including a particular denom and excluding a denom.
        return makeChangeHelper(coins, coinsLeft - 1, moneyLeft)
                + makeChangeHelper(coins, coinsLeft, moneyLeft - coins[coinsLeft - 1]);
    }

    // Dynamic Programming.
    public long makeChangeDP(int[] coins, int money) {
        int denomCount = coins.length;
        long[][] table = new long[money + 1][denomCount];

        // Possible ways to give change when money = 0 is 1.
        for (int col = 0; col < denomCount; col++)
            table[0][col] = 1;

        long countWithCoinM;
        long countWithoutCoinM;
        for (int row = 1; row <= money; row++) {
            for (int col = 0; col < denomCount; col++) {
                countWithCoinM = (row - coins[col] >= 0)? table[row - coins[col]][col]: 0;
                countWithoutCoinM = (col >= 1)? table[row][col - 1]: 0;
                table[row][col] = countWithCoinM + countWithoutCoinM;
            }
        }
        return table[money][denomCount - 1];
    }

    public long makeChange(int[] coins, int money) {
        return makeChangeHelper(coins, coins.length, money);
    }
}
