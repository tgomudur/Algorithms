package Array;

import java.util.Random;

/**
 * Shuffle and reset array
 * https://leetcode.com/problems/shuffle-an-array/#/description
 */
public class ShuffleArray {
    int[] nums;
    Random random;

    public ShuffleArray(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    // Fisher Yates Algorithm
    //    To shuffle an array a of n elements (indices 0..n-1):
    //        for i from n - 1 downto 1 do
    //              j = random integer with 0 <= j <= i
    //              exchange a[j] and a[i]
    public int[] shuffle() {
        int[] shuffled = nums.clone();
        int j = 0;
        for (int i = nums.length - 1; i >= 1; i--) {
            j = random.nextInt(i + 1);
            swap(shuffled, i, j);
        }
        return shuffled;
    }

    public void swap(int[] shuffled, int i, int j) {
        int tmp = shuffled[i];
        shuffled[i] = shuffled[j];
        shuffled[j] = tmp;
    }

    public int[] reset() {
        return nums;
    }
}
