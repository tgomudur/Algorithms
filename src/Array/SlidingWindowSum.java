package Array;

import java.util.*;
/**
 * Created by incyphae10 on 1/7/17.
 */
class SlidingWindowSumSolution {
    public List<Integer> findSlidingWindowSum(List<Integer> inputList, int windowSize) {
        int n = inputList.size();
        int windowSum = 0;
        int windowStartIdx = 0;
        List<Integer> resultList = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            if (i - windowStartIdx < windowSize) {
                windowSum += inputList.get(i);
            } else {
                resultList.add(windowSum);
                windowSum -= inputList.get(windowStartIdx);
                windowSum += inputList.get(i);
                windowStartIdx++;
            }
        }
        resultList.add(windowSum);
        return resultList;
    }
}

public class SlidingWindowSum {
    public static void main(String[] args) {
        SlidingWindowSumSolution s = new SlidingWindowSumSolution();
        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(s.findSlidingWindowSum(inputList, 2));
    }
}

