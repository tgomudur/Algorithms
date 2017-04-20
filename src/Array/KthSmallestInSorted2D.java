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

class ElementMinComparator implements Comparator<Element> {
    @Override
    public int compareTo(Element e1, Element e2) {
        return e1.val - e2.val;
    }
}

public class KthSmallestInSorted2D {
    // Using minHeap.
    // Time : O(nlogn + klogn)
    // Space : O(n)
    public int kthSmallestEfficient(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;

        PriorityQueue<Element> minHeap = new PriorityQueue<>(n, new ElementMinComparator());

        // Add first row to heap
        for (int col = 0; col < n; i++) {
            minHeap.add(new Element(0, col, matrix[0][col]));
        }

        // Add element below the min element to heap.
        for (int i = 0; i < k - 1; i++) {
            Element element = minHeap.remove();
            if (element.row + 1 == n) continue;
            minHeap.add(new Element(element.row + 1, element.col, matrix[element.row + 1][element.col]));
        }

        return minHeap.peek().val;
    }

    // Using maxHeap.
    // Time : O(n^2 + (n^2 - k)logk)
    // Space : O(k)
    public int kthSmallestInEfficientHeap(int[][] matrix, int k) {
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
    // Time Complexity: O(nlogn*log(max - min))
    // nlogn for finding num of elements < mid and binary search log(max - min)
    public int kthSmallestBinarySearch(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        int left = matrix[0][0], right = matrix[n - 1][m - 1], mid = 0;
        int numElementsBefore = 0, col = 0;

        while (left < right) {
            mid = left + (right - left)/2;
            numElementsBefore = 0, col = m - 1;
            for (int row = 0; row < n; row++) {
                while (col >= 0 && matrix[row][col] > mid)
                    col--;
                numsElementsBefore += col + 1;
            }
            if (numsElementsBefore < k) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    // Optimizing the binary search solution
    // The search to find numElementsBefore (ie num of elements < mid) can be optimized to be O(n)
    // instead of O(nlogn). Wicked Fast!!
    // Time : O(nlog(max - min))
    // Space : O(1)
    public int kthSmallestBinarySearchOptimized(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        int left = matrix[0][0], right = matrix[n - 1][m - 1], mid = 0;
        int numElementsBefore;
        while (left < right) {
            mid = left + (right - left)/2;
            numElementsBefore = countLessThanEqual(matrix, mid);
            if (numElementsBefore < k)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    public int countLessThanEqual(int[][] matrix, int mid) {
        int result = 0, n = matrix.length;
        int row = n - 1, col = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] > mid)
                row--;
            else {
                result += row + 1;
                col++;
            }
        }
        return result;
    }
}

