package Array;

/**
 * <p>Best Time to Buy and Sell Stock</p>
 * <p>Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.</p>
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/#/description">More Info</a>
 */
public class BuySellStock {
    public int findMaxProfit(int[] prices) {
        int n = prices.length;

        if (n == 0 || n == 1)
            return 0;

        int maxProfit = 0;
        int minSoFar = prices[0];

        for (int i = 1; i < n; i++) {
            minSoFar = Math.min(minSoFar, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
        }
        return maxProfit;
    }
}
