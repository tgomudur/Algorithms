package Array;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * Example:
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]],
 * k = 8,
 *
 * return 13.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/#/description
 */

class Element implements Comparable<Element>{
    int row;
    int col;
    int val;

    public Element(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }

    @Override
    public int compareTo(Element other) {
        return other.val - this.val;
    }
}
public class KthSmallestInSorted2D {
    // Using maxHeap.
    // Time : O(n^2 + (n^2 - k)logk)
    // Space : O(k)
    public int kthSmallest1(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;

        PriorityQueue<Element> maxHeap = new PriorityQueue<>(k);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (maxHeap.size() < k) {
                    maxHeap.add(new Element(i, j, matrix[i][j]));
                } else {
                    if (maxHeap.peek().val > matrix[i][j]) {
                        maxHeap.remove();
                        maxHeap.add(new Element(i, j, matrix[i][j]));
                    }
                }
            }
        }

        return maxHeap.peek().val;
    }

    // Using binary search
    public int kthSmallest(int[][] matrix, int k) {

    }
}
