package Array;

/**
 * <p>Merge Sort: Counting Inversions</p>
 * <a @href = "https://www.hackerrank.com/challenges/ctci-merge-sort"> More info</a>
 */
import java.io.*;

public class MergeSortInversion {
    public static long mergeHalves(int[] arr, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;

        int leftIdx = leftStart;
        int rightIdx = rightStart;
        int insertIdx = leftStart;
        int numOfElements = leftStart - rightEnd + 1;
        long count = 0;

        while (leftIdx <= leftEnd && rightIdx <= rightEnd) {
            if (arr[leftIdx] <= arr[rightIdx]) {
                temp[insertIdx] = arr[leftIdx++];
            } else {
                temp[insertIdx] = arr[rightIdx++];
                count += leftEnd - leftIdx + 1;
            }
            insertIdx++;
        }

        // Copy remaining elements
        while (leftIdx <= leftEnd) {
            temp[insertIdx++] = arr[leftIdx++];
        }

        while (rightIdx <= rightEnd) {
            temp[insertIdx++] = arr[rightIdx++];
        }

        // Copy the sorted half into array
        for (int i = leftStart; i <= rightEnd; i++) {
            arr[i] = temp[i];
        }

       /*for (int i : arr) {
          System.out.print(" " + i);
        }
        System.out.println();
        */
        return count;

    }
    public static long mergesort(int[] arr, int[] temp, int leftStart, int rightEnd) {
        if (leftStart < rightEnd) {
            int mid = (leftStart + rightEnd) / 2;
            long leftInvCounter = 0;
            long rightInvCounter = 0;
            long mergeCounter = 0;
            leftInvCounter = mergesort(arr, temp, leftStart, mid);
            rightInvCounter = mergesort(arr, temp, mid + 1, rightEnd);
            mergeCounter += mergeHalves(arr, temp, leftStart, rightEnd);
            return (leftInvCounter + rightInvCounter + mergeCounter);
        }
        return 0;
    }
    public static long countInversions(int[] arr){
        int[] temp = new int[arr.length];
        int[] original = new int[arr.length];
        System.arraycopy(arr, 0, original, 0, arr.length);

        return mergesort(arr, temp, 0, arr.length - 1);

        /*
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != original[i])
                count++;
        }
        return count;
        */
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            System.out.println(countInversions(arr));
        }
    }


}
