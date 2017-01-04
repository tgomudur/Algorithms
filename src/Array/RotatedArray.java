package Array;

/**
 * Created by incyphae10 on 1/3/17.
 */
class RotatedArraySolution {
    public int findRotationIndex(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int mid = 0;
        while (left < right) {
            if (nums[left] < nums[right]) return left;
            mid = (left + right)/2;
            if (nums[left] <= nums[mid])
                left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public int searchInRotatedArray(int[] nums, int target) {
        int rotationIdx = findRotationIndex(nums);
        int left = 0, right = nums.length - 1;
        int n = nums.length;
        int mid = 0, realMid = -1;
        while (left < right) {
            mid = (left + right)/2;
            realMid = (mid + rotationIdx)%n;
            if (nums[realMid] == target) return realMid;
            else if (nums[realMid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return realMid;
    }
}
public class RotatedArray {
    public static void main(String[] args) {
        RotatedArraySolution s = new RotatedArraySolution();
        int[] nums = { 4, 5, 6, 1, 2, 3};
//        System.out.println(s.findRotationIndex(nums));
        System.out.println(s.searchInRotatedArray(nums, 2));

    }
}
