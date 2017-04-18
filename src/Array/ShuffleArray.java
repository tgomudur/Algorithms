package Array;

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

    public int[] shuffle() {
        int[] shuffled = nums.clone();
        int j = 0;
        for (int i = nums.length - 1; i >= 1; i--) {
            j = random.nextInt(i + 1);
            swap(shuffled, i, j);
        }
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
